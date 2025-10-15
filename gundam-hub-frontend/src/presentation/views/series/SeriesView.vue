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
          }
        ]
      } catch (error) {
        console.error('Error loading series:', error)
      } finally {
        loading.value = false
      }
    }

    const viewSeriesDetails = (seriesId) => {
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

<style src="./SeriesView.css" scoped></style>