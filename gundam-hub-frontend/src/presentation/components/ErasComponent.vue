<template>
  <section class="universes">
    <div class="section-header">
      <h2 class="section-title">Universos</h2>
      <router-link to="/eras" class="view-all">Ver Todos</router-link>
    </div>
    <div class="eras-container">
      <div 
        v-for="era in eras" 
        :key="era.id" 
        class="era-card"
        @click="$router.push('/universe')"
      >
        <div 
          class="card-image era-image" 
          :style="{ backgroundImage: `url(${era.imageUrl})` }"
        ></div>
        <div class="card-content">
          <h3 class="card-title">{{ era.name }}</h3>
          <p class="card-meta">{{ era.year }}</p>
          <p class="card-description">{{ era.description }}</p>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { ref, onMounted } from 'vue'

export default {
  name: 'ErasComponent',
  setup() {
    const eras = ref([])

    const loadEras = async () => {
      try {
        eras.value = [
          {
            id: 1,
            name: 'Universal Century',
            year: '1979 - Presente',
            description: 'La línea de tiempo original y más extensa del universo Gundam.',
            imageUrl: 'https://images.unsplash.com/photo-1534447677768-be436bb09401?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80'
          },
          {
            id: 2,
            name: 'After Colony',
            year: '1995 - 1996',
            description: 'La era de Gundam Wing, con cinco jóvenes pilotos y sus Gundams.',
            imageUrl: 'https://images.unsplash.com/photo-1518709268805-4e9042af2176?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80'
          },
          {
            id: 3,
            name: 'Cosmic Era',
            year: '2002 - 2005',
            description: 'Gundam SEED y SEED Destiny, con el conflicto entre Coordinadores y Naturales.',
            imageUrl: 'https://images.unsplash.com/photo-1534447677768-be436bb09401?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80'
          },
          {
            id: 4,
            name: 'Anno Domini',
            year: '2007 - 2009',
            description: 'Gundam 00, ambientado en un futuro cercano con conflictos por recursos energéticos.',
            imageUrl: 'https://images.unsplash.com/photo-1518709268805-4e9042af2176?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80'
          }
        ]
      } catch (error) {
        console.error('Error loading eras:', error)
      }
    }

    onMounted(() => {
      loadEras()
    })

    return {
      eras
    }
  }
}
</script>

<style scoped>
/* Sin estilos - todo está en components.css */
</style>