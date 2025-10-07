import axios from 'axios'

const API_BASE = 'http://localhost:8080/api'

export const universeService = {
  async getAll() {
    const response = await axios.get(`${API_BASE}/universes`)
    return response.data
  }
}

export const seriesService = {
  async getAll() {
    const response = await axios.get(`${API_BASE}/series`)
    return response.data
  }
}

export const episodeService = {
  async getAll() {
    const response = await axios.get(`${API_BASE}/episodes`)
    return response.data
  }
}