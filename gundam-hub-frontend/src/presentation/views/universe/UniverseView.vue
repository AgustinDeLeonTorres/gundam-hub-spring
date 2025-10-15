<template>
  <div class="universe-view">
    <div class="header">
      <button @click="goBack" class="back-button">← 🏠 Volver a Universos</button>
      <div class="universe-header" v-if="universe">
        <div class="universe-icon">{{ universeIcon }}</div>
        <div class="universe-info">
          <h1>{{ universeDisplayName }}</h1>
          <p>{{ universe.description }}</p>
          <div class="universe-stats" v-if="!loading">
            <span>📺 {{ totalSeries }} series</span>
            <span>⏳ {{ eras.length }} eras</span>
          </div>
        </div>
      </div>
    </div>

    <div v-if="loading" class="loading-state">
      <div class="spinner">🔄</div>
      <p>Cargando eras y series...</p>
    </div>

    <div v-else-if="error" class="error-state">
      <h3>❌ Error al cargar el universo</h3>
      <p>{{ error }}</p>
      <button @click="loadUniverseData" class="retry-button">Reintentar</button>
    </div>

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
import { getUniverses, getErasByUniverse, getSeriesByEra } from '@/infrastructure/api/api.js';

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
        const universes = await getUniverses();
        this.universe = universes.find(u => u.id === this.universeId);
        
        if (!this.universe) {
          throw new Error(`Universo con ID ${this.universeId} no encontrado`);
        }

        this.eras = await getErasByUniverse(this.universeId);
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
      
      for (const era of this.eras) {
        try {
          const series = await getSeriesByEra(era.id);
          this.seriesCountByEra[era.id] = series.length;
        } catch (err) {
          console.error(`Error cargando series para era ${era.id}:`, err);
          this.seriesCountByEra[era.id] = 0;
        }
      }
    },

    getEraIcon(eraId) {
      const eraIcons = {
        1: '📅', 2: '⚔️', 3: '🕊️', 4: '⚡', 5: '👑', 6: '🔥', 7: '🕒', 8: '🚀',
        9: '🥊', 10: '🕊️', 11: '☠️', 12: '🦋', 13: '⚡', 14: '✝️', 15: '👶',
        16: '🔩', 17: '✨', 18: '🎭', 19: '🔬', 20: '🌀'
      };
      return eraIcons[eraId] || '📺';
    },

    getEraDisplayName(era) {
      const eraNames = {
        1: 'PRE-GUERRA', 2: 'GUERRA DE UN AÑO', 3: 'POST-GUERRA', 4: 'CONFLICTOS DE GRYPS',
        5: 'PRIMERA NEO-ZEON', 6: 'SEGUNDA NEO-ZEON', 7: 'LATE UC', 8: 'FAR FUTURE UC',
        9: 'FUTURE CENTURY', 10: 'AFTER COLONY', 11: 'AFTER WAR', 12: 'CORRECT CENTURY',
        13: 'COSMIC ERA', 14: 'ANNO DOMINI', 15: 'ADVANCED GENERATION', 16: 'POST DISASTER',
        17: 'AD STELLA', 18: 'BUILD SERIES', 19: 'EXPERIMENTALES', 20: 'G-QUX'
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
    },

    goBack() {
      this.$router.push('/universes');
    }
  }
};
</script>

<style src="./UniverseView.css" scoped></style>