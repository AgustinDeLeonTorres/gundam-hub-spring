<template>
  <div class="universe-list">
    <h1>Universos Gundam</h1>
    <div v-if="loading">Cargando universos...</div>
    <div v-else-if="error" class="alert alert-danger">{{ error }}</div>
    <div v-else>
      <div v-for="universe in universes" :key="universe.id" class="universe-item">
        <h3>{{ universe.name }}</h3>
        <p>{{ universe.description }}</p>
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
      error: null
    };
  },
  async mounted() {
    try {
      this.universes = await universeService.getAllUniverses();
    } catch (err) {
      this.error = 'Error al cargar los universos: ' + err.message;
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
</style>