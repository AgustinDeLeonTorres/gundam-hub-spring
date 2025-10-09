<template>
  <div class="home-view">
    <header class="app-header">
      <h1>🎌 GUNDAM HUB</h1>
      <p>Explora todos los universos y series de Gundam</p>
    </header>

    <div class="universes-grid">
      <div 
        v-for="universe in universes" 
        :key="universe.id" 
        class="universe-card"
        @click="goToUniverse(universe.id)"
      >
        <div class="universe-icon">
          {{ getUniverseIcon(universe.id) }}
        </div>
        <h3>{{ getUniverseDisplayName(universe) }}</h3>
        <p>{{ universe.description }}</p>
        <div class="universe-stats">
          <span>📺 {{ getSeriesCount(universe.id) }} series</span>
          <span>⏳ {{ getEraCount(universe.id) }} eras</span>
        </div>
        <div class="click-hint">Click para explorar →</div>
      </div>
    </div>

    <!-- Estados de carga y error (los mantienes de tu componente original) -->
    <div v-if="loading" class="loading-state">🔄 Cargando universos...</div>
    <div v-else-if="error" class="error-state">
      <strong>Error:</strong> {{ error }}
    </div>
  </div>
</template>

<script>
import { getUniverses } from '@/services/api.js';

export default {
  name: 'HomeView',
  data() {
    return {
      universes: [],
      loading: true,
      error: null
    };
  },
  async mounted() {
    try {
      console.log('🏠 Cargando datos para home...');
      this.universes = await getUniverses();
      console.log('✅ Universos cargados:', this.universes);
    } catch (err) {
      console.error('❌ Error cargando home:', err);
      this.error = 'Error al cargar los universos';
    } finally {
      this.loading = false;
    }
  },
  methods: {
    getUniverseIcon(universeId) {
      return universeId === 1 ? '🪐' : '🌌';
    },
    getUniverseDisplayName(universe) {
      if (universe.id === 1) return '🪐 UNIVERSAL CENTURY (UC)';
      if (universe.id === 2) return '🌌 ALTERNATE UNIVERSE (AU)';
      return universe.name;
    },
    getSeriesCount(universeId) {
      // Por ahora hardcodeado, luego lo calcularemos de la API
      return universeId === 1 ? 24 : 34;
    },
    getEraCount(universeId) {
      // Por ahora hardcodeado, luego lo calcularemos de la API  
      return universeId === 1 ? 8 : 12;
    },
    goToUniverse(universeId) {
      this.$router.push(`/universe/${universeId}`);
    }
  }
};
</script>

<style scoped>
.home-view {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.app-header {
  text-align: center;
  margin-bottom: 40px;
  padding: 20px;
  background: linear-gradient(135deg, #1a237e 0%, #283593 100%);
  color: white;
  border-radius: 12px;
}

.app-header h1 {
  margin: 0;
  font-size: 2.5em;
}

.app-header p {
  margin: 10px 0 0 0;
  opacity: 0.9;
  font-size: 1.1em;
}

.universes-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
  gap: 20px;
  margin-top: 20px;
}

.universe-card {
  background: white;
  border: 2px solid #e0e0e0;
  border-radius: 12px;
  padding: 25px;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
}

.universe-card:hover {
  transform: translateY(-5px);
  border-color: #3f51b5;
  box-shadow: 0 8px 25px rgba(63, 81, 181, 0.15);
}

.universe-icon {
  font-size: 3em;
  margin-bottom: 15px;
  text-align: center;
}

.universe-card h3 {
  margin: 0 0 10px 0;
  color: #1a237e;
  font-size: 1.4em;
}

.universe-card p {
  margin: 0 0 15px 0;
  color: #666;
  line-height: 1.5;
}

.universe-stats {
  display: flex;
  justify-content: space-between;
  margin-top: 15px;
  padding-top: 15px;
  border-top: 1px solid #f0f0f0;
  font-size: 0.9em;
  color: #666;
}

.click-hint {
  position: absolute;
  top: 15px;
  right: 15px;
  font-size: 0.8em;
  color: #3f51b5;
  opacity: 0;
  transition: opacity 0.3s ease;
}

.universe-card:hover .click-hint {
  opacity: 1;
}

.loading-state, .error-state {
  text-align: center;
  padding: 40px;
  font-size: 1.2em;
}

.error-state {
  color: #d32f2f;
  background: #ffebee;
  border-radius: 8px;
}
</style>