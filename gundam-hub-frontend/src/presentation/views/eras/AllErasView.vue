<template>
  <div class="all-eras-view">
    <div class="container">
      <div class="page-header">
        <h1>Todas las Eras Gundam</h1>
        <p>Explora todas las líneas temporales del universo Gundam</p>
      </div>
      
      <div class="eras-overview">
        <div class="era-category">
          <h2>🪐 Universal Century</h2>
          <div class="eras-grid">
            <div 
              v-for="era in ucEras" 
              :key="era.id" 
              class="era-item"
              @click="$router.push(`/era/${era.id}`)"
            >
              <div class="era-icon">{{ era.icon }}</div>
              <h3>{{ era.name }}</h3>
              <p>{{ era.description }}</p>
            </div>
          </div>
        </div>

        <div class="era-category">
          <h2>🌌 Alternate Universes</h2>
          <div class="eras-grid">
            <div 
              v-for="era in auEras" 
              :key="era.id" 
              class="era-item"
              @click="$router.push(`/era/${era.id}`)"
            >
              <div class="era-icon">{{ era.icon }}</div>
              <h3>{{ era.name }}</h3>
              <p>{{ era.description }}</p>
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
  name: 'AllErasView',
  setup() {
    const ucEras = ref([])
    const auEras = ref([])

    const loadEras = () => {
      ucEras.value = [
        { id: 1, name: 'PRE-GUERRA', description: 'Eventos previos a la Guerra de Un Año', icon: '📅' },
        { id: 2, name: 'GUERRA DE UN AÑO', description: 'Conflicto principal del Universal Century', icon: '⚔️' },
        { id: 3, name: 'POST-GUERRA', description: 'Período posterior a la guerra', icon: '🕊️' },
        { id: 4, name: 'CONFLICTOS DE GRYPS', description: 'Conflictos posteriores en Gryps', icon: '⚡' },
        { id: 5, name: 'PRIMERA NEO-ZEON', description: 'Primer levantamiento de Neo-Zeon', icon: '👑' },
        { id: 6, name: 'SEGUNDA NEO-ZEON', description: 'Segundo conflicto de Neo-Zeon', icon: '🔥' },
        { id: 7, name: 'LATE UC', description: 'Universal Century tardío', icon: '🕒' },
        { id: 8, name: 'FAR FUTURE UC', description: 'Universal Century del futuro lejano', icon: '🚀' }
      ]

      auEras.value = [
        { id: 9, name: 'FUTURE CENTURY', description: 'Era de G Gundam', icon: '🥊' },
        { id: 10, name: 'AFTER COLONY', description: 'Era de Gundam Wing', icon: '🕊️' },
        { id: 11, name: 'AFTER WAR', description: 'Era de Gundam X', icon: '☠️' },
        { id: 12, name: 'CORRECT CENTURY', description: 'Era de Turn A Gundam', icon: '🦋' },
        { id: 13, name: 'COSMIC ERA', description: 'Era de Gundam SEED', icon: '⚡' },
        { id: 14, name: 'ANNO DOMINI', description: 'Era de Gundam 00', icon: '✝️' },
        { id: 15, name: 'ADVANCED GENERATION', description: 'Era de Gundam AGE', icon: '👶' },
        { id: 16, name: 'POST DISASTER', description: 'Era de Iron-Blooded Orphans', icon: '🔩' },
        { id: 17, name: 'AD STELLA', description: 'Era de The Witch from Mercury', icon: '✨' }
      ]
    }

    onMounted(() => {
      loadEras()
    })

    return {
      ucEras,
      auEras
    }
  }
}
</script>

<style src="./AllErasView.css" scoped></style>