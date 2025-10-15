<template>
  <header class="header-component">
    <div class="container">
      <div class="header-content">
        <router-link to="/" class="logo">GUNDAM<span>HUB</span></router-link>
        <nav>
          <ul class="nav-menu">
            <li><router-link to="/" class="nav-link">Inicio</router-link></li>
            <li><router-link to="/universes" class="nav-link">Universos</router-link></li>
            <li><router-link to="/eras" class="nav-link">Eras</router-link></li>
            <li><router-link to="/series" class="nav-link">Series</router-link></li>
          </ul>
        </nav>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: 'HeaderComponent'
}
</script>

<style scoped>
/* Sin estilos - todo en global.css */
</style>