<template>
  <div class="about-view">
    <div class="container">
      <div class="page-header">
        <h1>Acerca de Gundam Hub</h1>
        <p>La base de datos definitiva para fanáticos de Gundam</p>
      </div>
      
      <div class="about-content">
        <div class="about-section">
          <h2>🎯 Nuestra Misión</h2>
          <p>Gundam Hub es un proyecto creado por y para fanáticos de la franquicia Gundam. Nuestro objetivo es proporcionar una base de datos completa y accesible que cubra todos los universos, eras, series y personajes del extenso mundo de Mobile Suits.</p>
        </div>

        <div class="about-section">
          <h2>📚 Qué Encontrarás</h2>
          <div class="features-grid">
            <div class="feature">
              <h3>🌌 Universos</h3>
              <p>Desde el Universal Century hasta los Alternate Universes</p>
            </div>
            <div class="feature">
              <h3>📅 Eras</h3>
              <p>Líneas temporales organizadas cronológicamente</p>
            </div>
            <div class="feature">
              <h3>🎬 Series</h3>
              <p>Información detallada de todas las series y OVAs</p>
            </div>
            <div class="feature">
              <h3>🤖 Mobile Suits</h3>
              <p>Catálogo completo de mechas y sus especificaciones</p>
            </div>
          </div>
        </div>

        <div class="about-section">
          <h2>🛠️ Tecnología</h2>
          <p>Este proyecto está construido con Vue 3 para el frontend y Spring Boot para el backend, siguiendo principios de Clean Architecture.</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AboutView'
}
</script>

<style scoped>
.about-view {
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

.about-content {
  max-width: 800px;
  margin: 0 auto;
}

.about-section {
  margin-bottom: 3rem;
}

.about-section h2 {
  font-size: 1.8rem;
  margin-bottom: 1rem;
  color: var(--highlight-color);
}

.about-section p {
  line-height: 1.6;
  color: #cccccc;
}

.features-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 1.5rem;
  margin-top: 1.5rem;
}

.feature {
  background-color: var(--card-bg);
  padding: 1.5rem;
  border-radius: 8px;
  border: 1px solid rgba(255, 255, 255, 0.1);
}

.feature h3 {
  margin-bottom: 0.5rem;
  color: var(--text-color);
}

.feature p {
  margin: 0;
  font-size: 0.9rem;
}

@media (max-width: 768px) {
  .page-header h1 {
    font-size: 2rem;
  }
  
  .features-grid {
    grid-template-columns: 1fr;
  }
}
</style>