<template>
  <div class="home-view">
    <HeroComponent />
    <div class="container">
      <ErasComponent />
      <SeriesComponent />
    </div>
  </div>
</template>

<script>
import HeroComponent from '@/presentation/components/HeroComponent.vue'
import ErasComponent from '@/presentation/components/ErasComponent.vue'
import SeriesComponent from '@/presentation/components/SeriesComponent.vue'

export default {
  name: 'HomeView',
  components: {
    HeroComponent,
    ErasComponent,
    SeriesComponent
  }
}
</script>

<style scoped>
/* Sin estilos - todo está en los archivos CSS modulares */
</style>