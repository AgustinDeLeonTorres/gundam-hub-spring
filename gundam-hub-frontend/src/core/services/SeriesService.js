import { getSeries, getSeriesById, getSeriesByEra } from '@/infrastructure/api/api'

class SeriesService {
  async getAllSeries() {
    return await getSeries()
  }

  async getSeriesById(id) {
    return await getSeriesById(id)
  }

  async getSeriesByEra(eraId) {
    return await getSeriesByEra(eraId)
  }
}

export default new SeriesService()