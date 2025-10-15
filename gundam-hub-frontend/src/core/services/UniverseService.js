import { getUniverses, getUniverseById } from '@/infrastructure/api/api'

class UniverseService {
  async getAllUniverses() {
    return await getUniverses()
  }

  async getUniverseById(id) {
    return await getUniverseById(id)
  }
}

export default new UniverseService()