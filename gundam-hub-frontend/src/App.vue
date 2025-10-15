<template>
  <div id="app">
    <HeaderComponent />
    <router-view />
    <FooterComponent />
  </div>
</template>

<script>
import HeaderComponent from '@/presentation/components/HeaderComponent.vue'
import FooterComponent from '@/presentation/components/FooterComponent.vue'

// Importar estilos modulares
import '@/presentation/styles/global.css'
import '@/presentation/styles/components.css'

export default {
  name: 'App',
  components: {
    HeaderComponent,
    FooterComponent
  }
}
</script>

<style>
/* App.vue queda SIN estilos - todo está en los archivos CSS modulares */
</style>