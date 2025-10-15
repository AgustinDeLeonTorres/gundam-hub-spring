<template>
  <section class="series">
    <div class="section-header">
      <h2 class="section-title">Series Populares</h2>
      <router-link to="/series" class="view-all">Ver Todas</router-link>
    </div>
    <div class="series-container">
      <div 
        v-for="series in seriesList" 
        :key="series.id" 
        class="series-card"
        @click="$router.push('/series')"
      >
        <div 
          class="card-image series-image" 
          :style="{ backgroundImage: `url(${series.imageUrl})` }"
        ></div>
        <div class="card-content">
          <h3 class="card-title">{{ series.name }}</h3>
          <div class="card-meta">
            <span>{{ series.timeline }}</span>
            <span>{{ series.episodes }} Episodios</span>
          </div>
          <p class="card-description">{{ series.description }}</p>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { ref, onMounted } from 'vue'

export default {
  name: 'SeriesComponent',
  setup() {
    const seriesList = ref([])

    const loadSeries = async () => {
      try {
        seriesList.value = [
          {
            id: 1,
            name: 'Mobile Suit Gundam',
            timeline: 'UC 0079',
            episodes: 43,
            description: 'La serie original que inició la franquicia y el conflicto entre la Federación Terrestre y el Principado de Zeon.',
            imageUrl: 'https://images.unsplash.com/photo-1534447677768-be436bb09401?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80'
          },
          {
            id: 2,
            name: 'Gundam Wing',
            timeline: 'AC 195',
            episodes: 49,
            description: 'Cinco jóvenes pilotos son enviados a la Tierra para completar la Operación Meteor.',
            imageUrl: 'https://images.unsplash.com/photo-1518709268805-4e9042af2176?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80'
          },
          {
            id: 3,
            name: 'Gundam SEED',
            timeline: 'CE 71',
            episodes: 50,
            description: 'La guerra entre la Alianza Terrestre y ZAFT, con el conflicto entre Naturales y Coordinadores.',
            imageUrl: 'https://images.unsplash.com/photo-1534447677768-be436bb09401?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80'
          },
          {
            id: 4,
            name: 'Iron-Blooded Orphans',
            timeline: 'PD 323',
            episodes: 50,
            description: 'Un grupo de niños soldados forma su propia compañía de seguridad privada en Marte.',
            imageUrl: 'https://images.unsplash.com/photo-1518709268805-4e9042af2176?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80'
          }
        ]
      } catch (error) {
        console.error('Error loading series:', error)
      }
    }

    onMounted(() => {
      loadSeries()
    })

    return {
      seriesList
    }
  }
}
</script>

<style scoped>
/* Sin estilos - todo está en components.css */
</style>