import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json'
  }
});

// Servicio para Universos
export const universeService = {
  getAllUniverses() {
    console.log('🔄 Haciendo petición a:', API_BASE_URL + '/universes');
    return apiClient.get('/universes')
      .then(response => {
        console.log('✅ Respuesta recibida:', response.data);
        return response.data;
      })
      .catch(error => {
        console.error('❌ Error completo:', error);
        console.error('🔍 Detalles del error:');
        if (error.response) {
          // El servidor respondió con un código de error
          console.error('Status:', error.response.status);
          console.error('Data:', error.response.data);
          console.error('Headers:', error.response.headers);
        } else if (error.request) {
          // La petición fue hecha pero no se recibió respuesta
          console.error('No se recibió respuesta. Request:', error.request);
        } else {
          // Algo pasó al configurar la petición
          console.error('Error de configuración:', error.message);
        }
        throw error;
      });
  },
  
  getUniverseById(id) {
    return apiClient.get(`/universes/${id}`)
      .then(response => response.data);
  },
  
  createUniverse(universeData) {
    return apiClient.post('/universes', universeData)
      .then(response => response.data);
  },
  
  updateUniverse(id, universeData) {
    return apiClient.put(`/universes/${id}`, universeData)
      .then(response => response.data);
  },
  
  deleteUniverse(id) {
    return apiClient.delete(`/universes/${id}`);
  }
};

export default apiClient;