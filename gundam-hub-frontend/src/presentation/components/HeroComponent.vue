<template>
  <section class="hero-section">
    <div class="container">
      <div class="hero-content">
        <h1 class="hero-title">Explora el Universo de Gundam</h1>
        <p class="hero-description">La base de datos definitiva para todos los fanáticos de Gundam. Descubre universos, eras, series y personajes del extenso mundo de Mobile Suits.</p>
        <router-link to="/series" class="btn">Explorar Ahora</router-link>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'HeroComponent'
}
</script>

<style scoped>
/* Sin estilos - todo está en components.css */
</style>