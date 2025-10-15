import { getEras, getEraById, getErasByUniverse } from '@/infrastructure/api/api'

class EraService {
  async getAllEras() {
    return await getEras()
  }

  async getEraById(id) {
    return await getEraById(id)
  }

  async getErasByUniverse(universeId) {
    return await getErasByUniverse(universeId)
  }
}

export default new EraService()