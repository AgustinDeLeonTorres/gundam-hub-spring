<template>
  <header class="header-component">
    <div class="container">
      <div class="header-content">
        <div class="logo">GUNDAM<span>HUB</span></div>
        <nav>
          <ul class="nav-menu">
            <li class="nav-item">
              <router-link to="/" class="nav-link">Inicio</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/universe" class="nav-link">Universos</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/eras" class="nav-link">Eras</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/series" class="nav-link">Series</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/mobile-suits" class="nav-link">Mobile Suits</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/characters" class="nav-link">Personajes</router-link>
            </li>
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
/* Sin estilos - todo está en components.css */
</style>