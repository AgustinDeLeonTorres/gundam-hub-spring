<template>
  <div class="era-view">
    <!-- Header -->
    <div class="header">
      <button @click="goBack" class="back-button">
        ← {{ backButtonText }}
      </button>
      <div class="era-header" v-if="era">
        <div class="era-icon">{{ eraIcon }}</div>
        <div class="era-info">
          <h1>{{ eraDisplayName }}</h1>
          <p>{{ era.description }}</p>
          <div class="era-meta">
            <span class="order">Orden cronológico: {{ era.chronologicalOrder }}</span>
            <span v-if="!era.isCanonical" class="non-canonical">No canónico</span>
            <span class="series-count">📺 {{ series.length }} series</span>
          </div>
        </div>
      </div>
    </div>

    <!-- Estados -->
    <div v-if="loading" class="loading-state">
      <div class="spinner">🔄</div>
      <p>Cargando series...</p>
    </div>

    <div v-else-if="error" class="error-state">
      <h3>❌ Error al cargar la era</h3>
      <p>{{ error }}</p>
      <button @click="loadEraData" class="retry-button">Reintentar</button>
    </div>

    <!-- Grid de Series -->
    <div v-else class="series-container">
      <h2>🎬 Series de esta Era</h2>
      
      <div v-if="series.length === 0" class="empty-state">
        <p>No hay series en esta era</p>
      </div>

      <div v-else class="series-grid">
        <div 
          v-for="serie in series" 
          :key="serie.id" 
          class="series-card"
        >
          <div class="series-header">
            <h3>{{ serie.title }}</h3>
            <span class="year">({{ serie.year }})</span>
          </div>
          
          <div class="series-details">
            <div class="series-type">
              <span class="type-badge">{{ serie.type }}</span>
            </div>
            <div class="series-length" v-if="serie.hoursLength">
              ⏱️ {{ serie.hoursLength }} horas
            </div>
          </div>

          <div class="series-actions">
            <button class="watch-button" @click="markAsWatched(serie.id)">
              👁️ Marcar como vista
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getEraById, getSeriesByEra, getUniverses } from '@/services/api.js';

export default {
  name: 'EraView',
  data() {
    return {
      era: null,
      universe: null,
      series: [],
      loading: true,
      error: null
    };
  },
  computed: {
    eraId() {
      return parseInt(this.$route.params.id);
    },
    eraIcon() {
      const eraIcons = {
        1: '📅', 2: '📅', 3: '📅', 4: '📅', 5: '📅', 6: '📅', 7: '📅', 8: '📅',
        9: '🥊', 10: '🕊️', 11: '☠️', 12: '🦋', 13: '⚡', 14: '✝️', 15: '👶',
        16: '🔩', 17: '✨', 18: '🎭', 19: '🔬', 20: '🚀'
      };
      return eraIcons[this.eraId] || '📺';
    },
    eraDisplayName() {
      if (!this.era) return 'Cargando...';
      
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
      
      return `${this.eraIcon} ${eraNames[this.eraId] || this.era.name}`;
    },
    backButtonText() {
      if (this.universe) {
        return this.universe.id === 1 ? '🪐 UNIVERSAL CENTURY' : '🌌 ALTERNATE UNIVERSE';
      }
      return 'Volver';
    }
  },
  async mounted() {
    await this.loadEraData();
  },
  methods: {
    async loadEraData() {
      this.loading = true;
      this.error = null;
      
      try {
        console.log(`🎌 Cargando era ${this.eraId}...`);
        
        // 1. Cargar datos de la era
        this.era = await getEraById(this.eraId);
        console.log('✅ Era cargada:', this.era);

        // 2. Cargar universo de la era
        const universes = await getUniverses();
        this.universe = universes.find(u => u.id === this.era.universe.id);
        console.log('✅ Universo cargado:', this.universe);

        // 3. Cargar series de la era
        this.series = await getSeriesByEra(this.eraId);
        console.log(`✅ ${this.series.length} series cargadas:`, this.series);
        
      } catch (err) {
        console.error('❌ Error cargando era:', err);
        this.error = err.message || 'Error al cargar los datos de la era';
      } finally {
        this.loading = false;
      }
    },

    goBack() {
      if (this.universe) {
        this.$router.push(`/universe/${this.universe.id}`);
      } else {
        this.$router.push('/');
      }
    },

    markAsWatched(seriesId) {
      console.log(`Marcando serie ${seriesId} como vista`);
      // Aquí implementarás la lógica después
      alert(`Serie ${seriesId} marcada como vista (funcionalidad futura)`);
    }
  }
};
</script>

<style scoped>
.era-view {
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

.era-header {
  display: flex;
  align-items: center;
  gap: 20px;
  padding: 25px;
  background: linear-gradient(135deg, #1a237e 0%, #283593 100%);
  color: white;
  border-radius: 12px;
}

.era-icon {
  font-size: 4em;
}

.era-info h1 {
  margin: 0 0 10px 0;
  font-size: 2em;
}

.era-info p {
  margin: 0 0 15px 0;
  opacity: 0.9;
  font-size: 1.1em;
}

.era-meta {
  display: flex;
  gap: 15px;
  font-size: 0.9em;
  flex-wrap: wrap;
}

.order, .series-count {
  background: rgba(255, 255, 255, 0.2);
  padding: 5px 12px;
  border-radius: 20px;
}

.non-canonical {
  background: #ff9800;
  color: white;
  padding: 5px 12px;
  border-radius: 20px;
  font-weight: 500;
}

/* Estados */
.loading-state, .error-state, .empty-state {
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

/* Grid de Series */
.series-container {
  margin-top: 30px;
}

.series-container h2 {
  color: #1a237e;
  margin-bottom: 20px;
  font-size: 1.8em;
}

.series-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 20px;
}

.series-card {
  background: white;
  border: 2px solid #e0e0e0;
  border-radius: 12px;
  padding: 20px;
  transition: all 0.3s ease;
}

.series-card:hover {
  transform: translateY(-3px);
  border-color: #3f51b5;
  box-shadow: 0 5px 20px rgba(63, 81, 181, 0.15);
}

.series-header {
  margin-bottom: 15px;
}

.series-header h3 {
  margin: 0 0 5px 0;
  color: #1a237e;
  font-size: 1.2em;
  line-height: 1.3;
}

.year {
  color: #666;
  font-size: 0.9em;
}

.series-details {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 15px;
  padding-bottom: 15px;
  border-bottom: 1px solid #f0f0f0;
}

.type-badge {
  background: #e3f2fd;
  color: #1565c0;
  padding: 4px 8px;
  border-radius: 12px;
  font-size: 0.8em;
  font-weight: 500;
}

.series-length {
  color: #666;
  font-size: 0.9em;
}

.series-actions {
  text-align: center;
}

.watch-button {
  background: #4caf50;
  color: white;
  border: none;
  padding: 8px 16px;
  border-radius: 6px;
  cursor: pointer;
  font-size: 0.9em;
  transition: background 0.3s ease;
}

.watch-button:hover {
  background: #388e3c;
}
</style>