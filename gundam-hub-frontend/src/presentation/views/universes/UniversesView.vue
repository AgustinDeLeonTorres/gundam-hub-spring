<template>
  <div class="universes-view">
    <div class="container">
      <div class="page-header">
        <h1>Universos Gundam</h1>
        <p>Selecciona un universo para explorar sus eras y series</p>
      </div>
      
      <div class="universes-grid">
        <div 
          v-for="universe in universes" 
          :key="universe.id" 
          class="universe-card"
          @click="$router.push(`/universe/${universe.id}`)"
        >
          <div class="universe-icon">{{ universe.icon }}</div>
          <h2>{{ universe.name }}</h2>
          <p>{{ universe.description }}</p>
          <div class="universe-stats">
            <span>{{ universe.eras }} eras</span>
            <span>{{ universe.series }} series</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue'

export default {
  name: 'UniversesView',
  setup() {
    const universes = ref([])

    const loadUniverses = () => {
      universes.value = [
        {
          id: 1,
          name: '🪐 Universal Century',
          description: 'La línea de tiempo original y principal de Gundam',
          icon: '🪐',
          eras: 8,
          series: 15
        },
        {
          id: 2, 
          name: '🌌 Alternate Universes',
          description: 'Líneas temporales alternativas independientes',
          icon: '🌌',
          eras: 12,
          series: 25
        }
      ]
    }

    onMounted(() => {
      loadUniverses()
    })

    return {
      universes
    }
  }
}
</script>

<style src="./UniversesView.css" scoped></style>