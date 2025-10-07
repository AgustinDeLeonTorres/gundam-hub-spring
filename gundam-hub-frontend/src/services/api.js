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
    return apiClient.get('/universes')
      .then(response => response.data)
      .catch(error => {
        console.error('Error fetching universes:', error);
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