<template>
  <div class="universe-list">
    <h1>Universos Gundam</h1>
    <div v-if="loading">Cargando universos...</div>
    <div v-else-if="error" class="alert alert-danger">
      <strong>Error:</strong> {{ error }}
      <div v-if="errorDetails" class="error-details">
        <small>{{ errorDetails }}</small>
      </div>
    </div>
    <div v-else>
      <div v-if="universes.length === 0" class="alert alert-info">
        No se encontraron universos.
      </div>
      <div v-else>
        <div v-for="universe in universes" :key="universe.id" class="universe-item">
          <h3>{{ universe.name }}</h3>
          <p>{{ universe.description }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { universeService } from '@/services/api.js';

export default {
  name: 'UniverseList',
  data() {
    return {
      universes: [],
      loading: true,
      error: null,
      errorDetails: null
    };
  },
  async mounted() {
    try {
      console.log('🚀 Iniciando carga de universos...');
      this.universes = await universeService.getAllUniverses();
      console.log('🎉 Universos cargados exitosamente:', this.universes);
    } catch (err) {
      console.error('💥 Error en componente:', err);
      this.error = 'Error al cargar los universos';
      this.errorDetails = err.message;
      
      // Mensaje más específico según el tipo de error
      if (err.code === 'NETWORK_ERROR' || err.message.includes('Network')) {
        this.error = 'Error de conexión con el servidor';
        this.errorDetails = 'Verifica que el backend esté ejecutándose en puerto 8080';
      }
    } finally {
      this.loading = false;
    }
  }
};
</script>

<style scoped>
.universe-list {
  padding: 20px;
}
.universe-item {
  border: 1px solid #ddd;
  padding: 15px;
  margin: 10px 0;
  border-radius: 5px;
}
.alert {
  padding: 10px;
  border-radius: 5px;
  margin: 10px 0;
}
.alert-danger {
  background-color: #f8d7da;
  border: 1px solid #f5c6cb;
  color: #721c24;
}
.alert-info {
  background-color: #d1ecf1;
  border: 1px solid #bee5eb;
  color: #0c5460;
}
.error-details {
  margin-top: 5px;
  font-style: italic;
}
</style>