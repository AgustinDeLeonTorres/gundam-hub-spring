<template>
  <div id="app">
    <nav class="navbar navbar-dark bg-dark">
      <div class="container">
        <span class="navbar-brand mb-0 h1">🎯 Gundam Hub</span>
      </div>
    </nav>
    
    <div class="container mt-4">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  min-height: 100vh;
}
</style>