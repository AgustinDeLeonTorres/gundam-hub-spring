<template>
  <div class="mobile-suits-view">
    <div class="container">
      <div class="page-header">
        <h1>Mobile Suits</h1>
        <p>Catálogo completo de mechas Gundam</p>
      </div>
      
      <div class="content-placeholder">
        <div class="placeholder-icon">🤖</div>
        <h2>Próximamente</h2>
        <p>Estamos trabajando en el catálogo completo de Mobile Suits.</p>
        <p>Incluirá especificaciones técnicas, pilotos y galerías de imágenes.</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MobileSuitsView'
}
</script>

<style scoped>
.mobile-suits-view {
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

.content-placeholder {
  text-align: center;
  padding: 4rem 2rem;
  background-color: var(--card-bg);
  border-radius: 10px;
  border: 1px solid rgba(255, 255, 255, 0.1);
}

.placeholder-icon {
  font-size: 4rem;
  margin-bottom: 1rem;
}

.content-placeholder h2 {
  font-size: 1.8rem;
  margin-bottom: 1rem;
  color: var(--highlight-color);
}

.content-placeholder p {
  color: #cccccc;
  line-height: 1.6;
  margin-bottom: 0.5rem;
}
</style>