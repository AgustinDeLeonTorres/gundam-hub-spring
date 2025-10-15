<template>
  <footer class="footer-component">
    <div class="container">
      <div class="footer-content">
        <div class="footer-column">
          <h3>Gundam Hub</h3>
          <ul class="footer-list">
            <li class="footer-item">
              <router-link to="/about" class="footer-link">Acerca de</router-link>
            </li>
            <li class="footer-item">
              <a href="#" class="footer-link">Contacto</a>
            </li>
            <li class="footer-item">
              <a href="#" class="footer-link">Política de Privacidad</a>
            </li>
            <li class="footer-item">
              <a href="#" class="footer-link">Términos de Uso</a>
            </li>
          </ul>
        </div>
        
        <div class="footer-column">
          <h3>Universos</h3>
          <ul class="footer-list">
            <li class="footer-item">
              <router-link to="/universe" class="footer-link">Universal Century</router-link>
            </li>
            <li class="footer-item">
              <router-link to="/universe" class="footer-link">After Colony</router-link>
            </li>
            <li class="footer-item">
              <router-link to="/universe" class="footer-link">Cosmic Era</router-link>
            </li>
            <li class="footer-item">
              <router-link to="/universe" class="footer-link">Anno Domini</router-link>
            </li>
          </ul>
        </div>
        
        <div class="footer-column">
          <h3>Series</h3>
          <ul class="footer-list">
            <li class="footer-item">
              <router-link to="/series" class="footer-link">Mobile Suit Gundam</router-link>
            </li>
            <li class="footer-item">
              <router-link to="/series" class="footer-link">Gundam Wing</router-link>
            </li>
            <li class="footer-item">
              <router-link to="/series" class="footer-link">Gundam SEED</router-link>
            </li>
            <li class="footer-item">
              <router-link to="/series" class="footer-link">Iron-Blooded Orphans</router-link>
            </li>
          </ul>
        </div>
        
        <div class="footer-column">
          <h3>Recursos</h3>
          <ul class="footer-list">
            <li class="footer-item">
              <router-link to="/mobile-suits" class="footer-link">Mobile Suits</router-link>
            </li>
            <li class="footer-item">
              <router-link to="/characters" class="footer-link">Personajes</router-link>
            </li>
            <li class="footer-item">
              <router-link to="/episodes" class="footer-link">Episodios</router-link>
            </li>
            <li class="footer-item">
              <router-link to="/timeline" class="footer-link">Timeline</router-link>
            </li>
          </ul>
        </div>
      </div>
      
      <div class="copyright">
        <p>&copy; 2023 Gundam Hub. Todos los derechos reservados. Gundam es una marca registrada de Bandai Namco Filmworks Inc.</p>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'FooterComponent'
}
</script>

<style scoped>
/* Sin estilos - todo está en components.css */
</style>