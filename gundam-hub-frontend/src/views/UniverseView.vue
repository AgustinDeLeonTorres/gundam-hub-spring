<template>
  <div class="universe-view">
    <!-- Header con breadcrumb -->
    <div class="header">
      <button @click="$router.push('/')" class="back-button">
        ← 🏠 GUNDAM HUB
      </button>
      <div class="universe-header">
        <div class="universe-icon">{{ universeIcon }}</div>
        <div class="universe-info">
          <h1>{{ universeDisplayName }}</h1>
          <p v-if="universe">{{ universe.description }}</p>
          <div class="universe-stats" v-if="!loading">
            <span>📺 {{ totalSeries }} series</span>
            <span>⏳ {{ eras.length }} eras</span>
          </div>
        </div>
      </div>
    </div>

    <!-- Estados de carga y error -->
    <div v-if="loading" class="loading-state">
      <div class="spinner">🔄</div>
      <p>Cargando eras y series...</p>
    </div>

    <div v-else-if="error" class="error-state">
      <h3>❌ Error al cargar el universo</h3>
      <p>{{ error }}</p>
      <button @click="loadUniverseData" class="retry-button">Reintentar</button>
    </div>

    <!-- Lista de eras -->
    <div v-else class="eras-container">
      <h2>📅 Línea Temporal</h2>
      <div class="eras-list">
        <div 
          v-for="era in eras" 
          :key="era.id" 
          class="era-card"
          @click="goToEra(era.id)"
        >
          <div class="era-header">
            <div class="era-icon">{{ getEraIcon(era.id) }}</div>
            <div class="era-info">
              <h3>{{ getEraDisplayName(era) }}</h3>
              <p>{{ era.description }}</p>
              <div class="era-meta">
                <span class="order">Orden: {{ era.chronologicalOrder }}</span>
                <span v-if="!era.isCanonical" class="non-canonical">No canónico</span>
              </div>
            </div>
            <div class="era-series-count">
              <span class="count">{{ getSeriesCountForEra(era.id) }}</span>
              <span class="label">series</span>
              <div class="click-hint">→</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getUniverses, getErasByUniverse, getSeriesByEra } from '@/services/api.js';

export default {
  name: 'UniverseView',
  data() {
    return {
      universe: null,
      eras: [],
      seriesCountByEra: {},
      loading: true,
      error: null
    };
  },
  computed: {
    universeId() {
      return parseInt(this.$route.params.id);
    },
    universeIcon() {
      return this.universeId === 1 ? '🪐' : '🌌';
    },
    universeDisplayName() {
      if (!this.universe) return 'Cargando...';
      return this.universeId === 1 
        ? '🪐 UNIVERSAL CENTURY (UC)' 
        : '🌌 ALTERNATE UNIVERSE (AU)';
    },
    totalSeries() {
      return Object.values(this.seriesCountByEra).reduce((sum, count) => sum + count, 0);
    }
  },
  async mounted() {
    await this.loadUniverseData();
  },
  methods: {
    async loadUniverseData() {
      this.loading = true;
      this.error = null;
      
      try {
        console.log(`🎯 Cargando universo ${this.universeId}...`);
        
        // 1. Cargar datos del universo
        const universes = await getUniverses();
        this.universe = universes.find(u => u.id === this.universeId);
        
        if (!this.universe) {
          throw new Error(`Universo con ID ${this.universeId} no encontrado`);
        }

        // 2. Cargar eras del universo
        this.eras = await getErasByUniverse(this.universeId);
        console.log(`✅ ${this.eras.length} eras cargadas:`, this.eras);

        // 3. Para cada era, cargar count de series
        await this.loadSeriesCounts();
        
      } catch (err) {
        console.error('❌ Error cargando universo:', err);
        this.error = err.message || 'Error al cargar los datos del universo';
      } finally {
        this.loading = false;
      }
    },

    async loadSeriesCounts() {
      this.seriesCountByEra = {};
      
      // Cargar series count para cada era
      for (const era of this.eras) {
        try {
          const series = await getSeriesByEra(era.id);
          this.seriesCountByEra[era.id] = series.length;
          console.log(`📊 Era ${era.id}: ${series.length} series`);
        } catch (err) {
          console.error(`Error cargando series para era ${era.id}:`, err);
          this.seriesCountByEra[era.id] = 0;
        }
      }
    },

    getEraIcon(eraId) {
      const eraIcons = {
        // UC Eras
        1: '📅', 2: '📅', 3: '📅', 4: '📅', 5: '📅', 6: '📅', 7: '📅', 8: '📅',
        // AU Eras  
        9: '🥊', 10: '🕊️', 11: '☠️', 12: '🦋', 13: '⚡', 14: '✝️', 15: '👶',
        16: '🔩', 17: '✨', 18: '🎭', 19: '🔬', 20: '🚀'
      };
      return eraIcons[eraId] || '📺';
    },

    getEraDisplayName(era) {
      const eraNames = {
        1: 'PRE-GUERRA',
        2: 'GUERRA DE UN AÑO', 
        3: 'POST-GUERRA',
        4: 'CONFLICTOS DE GRYPS',
        5: 'PRIMERA NEO-ZEON',
        6: 'SEGUNDA NEO-ZEON',
        7: 'LATE UC',
        8: 'FAR FUTURE UC',
        9: 'FUTURE CENTURY',
        10: 'AFTER COLONY',
        11: 'AFTER WAR',
        12: 'CORRECT CENTURY',
        13: 'COSMIC ERA',
        14: 'ANNO DOMINI',
        15: 'ADVANCED GENERATION',
        16: 'POST DISASTER', 
        17: 'AD STELLA',
        18: 'BUILD SERIES',
        19: 'EXPERIMENTALES',
        20: 'GQuuuuuuX'
      };
      
      const icon = this.getEraIcon(era.id);
      const name = eraNames[era.id] || era.name;
      return `${icon} ${name}`;
    },

    getSeriesCountForEra(eraId) {
      return this.seriesCountByEra[eraId] || 0;
    },

    goToEra(eraId) {
      this.$router.push(`/era/${eraId}`);
    }
  }
};
</script>

<style scoped>
.universe-view {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.header {
  margin-bottom: 30px;
}

.back-button {
  background: #3f51b5;
  color: white;
  border: none;
  padding: 12px 20px;
  border-radius: 8px;
  cursor: pointer;
  font-size: 1em;
  margin-bottom: 20px;
  transition: background 0.3s ease;
}

.back-button:hover {
  background: #283593;
  transform: translateX(-2px);
}

.universe-header {
  display: flex;
  align-items: center;
  gap: 20px;
  padding: 25px;
  background: linear-gradient(135deg, #1a237e 0%, #283593 100%);
  color: white;
  border-radius: 12px;
}

.universe-icon {
  font-size: 4em;
}

.universe-info h1 {
  margin: 0 0 10px 0;
  font-size: 2em;
}

.universe-info p {
  margin: 0 0 15px 0;
  opacity: 0.9;
  font-size: 1.1em;
}

.universe-stats {
  display: flex;
  gap: 20px;
  font-size: 1em;
}

.universe-stats span {
  background: rgba(255, 255, 255, 0.2);
  padding: 5px 12px;
  border-radius: 20px;
  font-weight: 500;
}

/* Estados */
.loading-state, .error-state {
  text-align: center;
  padding: 60px 20px;
}

.spinner {
  font-size: 3em;
  margin-bottom: 20px;
  animation: spin 2s linear infinite;
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

.error-state h3 {
  color: #d32f2f;
  margin-bottom: 10px;
}

.retry-button {
  background: #d32f2f;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 6px;
  cursor: pointer;
  margin-top: 15px;
}

/* Lista de Eras */
.eras-container {
  margin-top: 30px;
}

.eras-container h2 {
  color: #1a237e;
  margin-bottom: 20px;
  font-size: 1.8em;
}

.eras-list {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.era-card {
  background: white;
  border: 2px solid #e0e0e0;
  border-radius: 12px;
  padding: 20px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.era-card:hover {
  transform: translateX(5px);
  border-color: #3f51b5;
  box-shadow: 0 5px 20px rgba(63, 81, 181, 0.15);
}

.era-header {
  display: flex;
  align-items: center;
  gap: 20px;
}

.era-icon {
  font-size: 2.5em;
  flex-shrink: 0;
}

.era-info {
  flex: 1;
}

.era-info h3 {
  margin: 0 0 8px 0;
  color: #1a237e;
  font-size: 1.3em;
}

.era-info p {
  margin: 0 0 10px 0;
  color: #666;
  line-height: 1.5;
}

.era-meta {
  display: flex;
  gap: 15px;
  font-size: 0.9em;
}

.order {
  color: #666;
}

.non-canonical {
  background: #ff9800;
  color: white;
  padding: 2px 8px;
  border-radius: 12px;
  font-size: 0.8em;
}

.era-series-count {
  text-align: center;
  flex-shrink: 0;
  min-width: 80px;
}

.count {
  display: block;
  font-size: 1.8em;
  font-weight: bold;
  color: #3f51b5;
}

.label {
  font-size: 0.8em;
  color: #666;
}

.click-hint {
  margin-top: 5px;
  font-size: 1.2em;
  opacity: 0;
  transition: opacity 0.3s ease;
}

.era-card:hover .click-hint {
  opacity: 1;
}
</style>