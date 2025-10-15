<template>
  <div class="series-view">
    <div class="container">
      <div class="page-header">
        <h1>Todas las Series Gundam</h1>
        <p>Explora la completa colección de series y OVAs</p>
      </div>
      
      <div class="series-content">
        <div class="loading-message" v-if="loading">
          <p>Cargando series...</p>
        </div>
        
        <div class="series-grid" v-else>
          <div 
            v-for="series in seriesList" 
            :key="series.id" 
            class="series-card"
            @click="viewSeriesDetails(series.id)"
          >
            <div 
              class="series-image" 
              :style="{ backgroundImage: `url(${series.imageUrl})` }"
            ></div>
            <div class="series-info">
              <h3>{{ series.title }}</h3>
              <div class="series-meta">
                <span class="year">{{ series.year }}</span>
                <span class="episodes">{{ series.episodes }} episodios</span>
              </div>
              <p class="description">{{ series.description }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue'

export default {
  name: 'SeriesView',
  setup() {
    const seriesList = ref([])
    const loading = ref(true)

    const loadSeries = async () => {
      try {
        // Datos de ejemplo - conectar con API después
        seriesList.value = [
          {
            id: 1,
            title: 'Mobile Suit Gundam',
            year: '1979',
            episodes: 43,
            description: 'La serie original que inició la franquicia Gundam.',
            imageUrl: 'https://images.unsplash.com/photo-1534447677768-be436bb09401?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80'
          },
          {
            id: 2,
            title: 'Gundam Wing',
            year: '1995',
            episodes: 49,
            description: 'Cinco jóvenes pilotos son enviados a la Tierra en la Operación Meteor.',
            imageUrl: 'https://images.unsplash.com/photo-1518709268805-4e9042af2176?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80'
          },
          {
            id: 3,
            title: 'Gundam SEED',
            year: '2002',
            episodes: 50,
            description: 'Conflicto entre Naturales y Coordinadores en la era cósmica.',
            imageUrl: 'https://images.unsplash.com/photo-1534447677768-be436bb09401?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80'
          },
          {
            id: 4,
            title: 'Iron-Blooded Orphans',
            year: '2015',
            episodes: 50,
            description: 'Un grupo de niños soldados forma su propia compañía en Marte.',
            imageUrl: 'https://images.unsplash.com/photo-1518709268805-4e9042af2176?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80'
          }
        ]
      } catch (error) {
        console.error('Error loading series:', error)
      } finally {
        loading.value = false
      }
    }

    const viewSeriesDetails = (seriesId) => {
      // Navegar a detalles de la serie (implementar después)
      console.log('Viewing series:', seriesId)
    }

    onMounted(() => {
      loadSeries()
    })

    return {
      seriesList,
      loading,
      viewSeriesDetails
    }
  }
}
</script>

<style scoped>
.series-view {
  padding: 2rem 0;
}

.page-header {
  text-align: center;
  margin-bottom: 3rem;
}

.page-header h1 {
  font-size: 2.5rem;
  margin-bottom: 1rem;
  color: var(--text-color);
}

.page-header p {
  font-size: 1.2rem;
  color: #cccccc;
}

.loading-message {
  text-align: center;
  padding: 3rem;
  color: #cccccc;
}

.series-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 2rem;
}

.series-card {
  background-color: var(--card-bg);
  border-radius: 10px;
  overflow: hidden;
  transition: transform 0.3s, box-shadow 0.3s;
  cursor: pointer;
  border: 1px solid rgba(255, 255, 255, 0.1);
}

.series-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3);
}

.series-image {
  height: 200px;
  background-size: cover;
  background-position: center;
  background-color: #2a2a2a; /* Fallback color */
}

.series-info {
  padding: 1.5rem;
}

.series-info h3 {
  font-size: 1.3rem;
  margin-bottom: 0.5rem;
  color: var(--text-color);
}

.series-meta {
  display: flex;
  justify-content: space-between;
  margin-bottom: 1rem;
  font-size: 0.9rem;
  color: #cccccc;
}

.description {
  line-height: 1.5;
  color: #cccccc;
  font-size: 0.95rem;
}

@media (max-width: 768px) {
  .series-grid {
    grid-template-columns: 1fr;
  }
  
  .page-header h1 {
    font-size: 2rem;
  }
}
</style>