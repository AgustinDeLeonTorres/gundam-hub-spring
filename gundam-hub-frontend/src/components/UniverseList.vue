<template>
  <div class="container mt-4">
    <h1 class="text-center mb-4">🌌 Universos Gundam</h1>
    
    <div v-if="loading" class="text-center">
      <div class="spinner-border text-primary" role="status">
        <span class="visually-hidden">Cargando...</span>
      </div>
      <p class="mt-2">Cargando universos...</p>
    </div>
    
    <div v-else class="row">
      <div v-for="universe in universes" :key="universe.id" class="col-md-6 col-lg-4 mb-4">
        <div class="card h-100 shadow-sm">
          <div class="card-body">
            <h5 class="card-title">{{ universe.name }}</h5>
            <p class="card-text">{{ universe.description }}</p>
            <div class="d-flex justify-content-between align-items-center">
              <small class="text-muted">Año: {{ universe.year }}</small>
              <button class="btn btn-outline-primary btn-sm">
                Ver Series
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <div v-if="error" class="alert alert-danger mt-3" role="alert">
      Error cargando universos: {{ error }}
    </div>
  </div>
</template>

<script>
import { universeService } from '@/services/api.js'

export default {
  name: 'UniverseList',
  data() {
    return {
      universes: [],
      loading: true,
      error: null
    }
  },
  async mounted() {
    try {
      this.universes = await universeService.getAll()
    } catch (err) {
      this.error = err.message
      console.error('Error loading universes:', err)
    } finally {
      this.loading = false
    }
  }
}
</script>

<style scoped>
.card {
  transition: transform 0.2s;
}
.card:hover {
  transform: translateY(-5px);
}
</style>