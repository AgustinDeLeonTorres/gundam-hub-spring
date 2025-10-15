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
        {
          id: 1,
          name: 'PRE-GUERRA',
          description: 'Eventos previos a la Guerra de Un Año',
          icon: '📅'
        },
        {
          id: 2, 
          name: 'GUERRA DE UN AÑO',
          description: 'Conflicto principal del Universal Century',
          icon: '⚔️'
        },
        {
          id: 3,
          name: 'POST-GUERRA',
          description: 'Período posterior a la guerra',
          icon: '🕊️'
        }
      ]

      auEras.value = [
        {
          id: 10,
          name: 'AFTER COLONY',
          description: 'Era de Gundam Wing',
          icon: '🕊️'
        },
        {
          id: 13,
          name: 'COSMIC ERA', 
          description: 'Era de Gundam SEED',
          icon: '⚡'
        },
        {
          id: 14,
          name: 'ANNO DOMINI',
          description: 'Era de Gundam 00',
          icon: '✝️'
        }
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

<style scoped>
.all-eras-view {
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

.era-category {
  margin-bottom: 3rem;
}

.era-category h2 {
  font-size: 1.8rem;
  margin-bottom: 1.5rem;
  color: var(--highlight-color);
}

.eras-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 1.5rem;
}

.era-item {
  background-color: var(--card-bg);
  border-radius: 10px;
  padding: 1.5rem;
  transition: transform 0.3s, box-shadow 0.3s;
  cursor: pointer;
  border: 1px solid rgba(255, 255, 255, 0.1);
}

.era-item:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3);
}

.era-icon {
  font-size: 2.5rem;
  margin-bottom: 1rem;
}

.era-item h3 {
  font-size: 1.3rem;
  margin-bottom: 0.5rem;
  color: var(--text-color);
}

.era-item p {
  color: #cccccc;
  line-height: 1.5;
}

@media (max-width: 768px) {
  .eras-grid {
    grid-template-columns: 1fr;
  }
  
  .page-header h1 {
    font-size: 2rem;
  }
}
</style>