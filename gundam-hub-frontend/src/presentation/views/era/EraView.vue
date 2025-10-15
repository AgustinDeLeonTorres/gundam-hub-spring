<template>
  <div class="era-view">
    <div class="header">
      <button @click="goBack" class="back-button">← {{ backButtonText }}</button>
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

    <div v-if="loading" class="loading-state">
      <div class="spinner">🔄</div>
      <p>Cargando series...</p>
    </div>

    <div v-else-if="error" class="error-state">
      <h3>❌ Error al cargar la era</h3>
      <p>{{ error }}</p>
      <button @click="loadEraData" class="retry-button">Reintentar</button>
    </div>

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
import { getEraById, getSeriesByEra, getUniverses } from '@/infrastructure/api/api.js';

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
        1: '📅', 2: '⚔️', 3: '🕊️', 4: '⚡', 5: '👑', 6: '🔥', 7: '🕒', 8: '🚀',
        9: '🥊', 10: '🕊️', 11: '☠️', 12: '🦋', 13: '⚡', 14: '✝️', 15: '👶',
        16: '🔩', 17: '✨', 18: '🎭', 19: '🔬', 20: '🌀'
      };
      return eraIcons[this.eraId] || '📺';
    },
    eraDisplayName() {
      if (!this.era) return 'Cargando...';
      
      const eraNames = {
        1: 'PRE-GUERRA', 2: 'GUERRA DE UN AÑO', 3: 'POST-GUERRA', 4: 'CONFLICTOS DE GRYPS',
        5: 'PRIMERA NEO-ZEON', 6: 'SEGUNDA NEO-ZEON', 7: 'LATE UC', 8: 'FAR FUTURE UC',
        9: 'FUTURE CENTURY', 10: 'AFTER COLONY', 11: 'AFTER WAR', 12: 'CORRECT CENTURY',
        13: 'COSMIC ERA', 14: 'ANNO DOMINI', 15: 'ADVANCED GENERATION', 16: 'POST DISASTER',
        17: 'AD STELLA', 18: 'BUILD SERIES', 19: 'EXPERIMENTALES', 20: 'G-QUX'
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
        this.era = await getEraById(this.eraId);
        const universes = await getUniverses();
        this.universe = universes.find(u => u.id === this.era.universe.id);
        this.series = await getSeriesByEra(this.eraId);
        
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
      alert(`Serie ${seriesId} marcada como vista (funcionalidad futura)`);
    }
  }
};
</script>

<style src="./EraView.css" scoped></style>