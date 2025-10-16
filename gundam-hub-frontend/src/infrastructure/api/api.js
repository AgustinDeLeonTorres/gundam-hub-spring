const API_URL = 'http://localhost:8080/api';

// =========================
// UNIVERSOS
// =========================
export const getUniverses = async () => {
  try {
    const response = await fetch(`${API_URL}/universes`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error('❌ Error en getUniverses:', error);
    throw error;
  }
};

export const getUniverseById = async (id) => {
  try {
    const response = await fetch(`${API_URL}/universes/${id}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getUniverseById(${id}):`, error);
    throw error;
  }
};

// =========================
// ERAS
// =========================
export const getEras = async () => {
  try {
    const response = await fetch(`${API_URL}/eras`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error('❌ Error en getEras:', error);
    throw error;
  }
};

export const getEraById = async (id) => {
  try {
    const response = await fetch(`${API_URL}/eras/${id}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getEraById(${id}):`, error);
    throw error;
  }
};

export const getErasByUniverse = async (universeId) => {
  try {
    const response = await fetch(`${API_URL}/eras/universe/${universeId}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getErasByUniverse(${universeId}):`, error);
    throw error;
  }
};

// =========================
// SERIES
// =========================
export const getSeries = async () => {
  try {
    const response = await fetch(`${API_URL}/series`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error('❌ Error en getSeries:', error);
    throw error;
  }
};

export const getSeriesById = async (id) => {
  try {
    const response = await fetch(`${API_URL}/series/${id}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeriesById(${id}):`, error);
    throw error;
  }
};

export const getSeriesByEra = async (eraId) => {
  try {
    const response = await fetch(`${API_URL}/series/era/${eraId}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeriesByEra(${eraId}):`, error);
    throw error;
  }
};

export const getSeriesByUniverse = async (universeId) => {
  try {
    const response = await fetch(`${API_URL}/series/universe/${universeId}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeriesByUniverse(${universeId}):`, error);
    throw error;
  }
};

// =========================
// TEMPORADAS (SEASONS) 
// =========================
export const getSeasons = async () => {
  try {
    const response = await fetch(`${API_URL}/seasons`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error('❌ Error en getSeasons:', error);
    throw error;
  }
};

export const getSeasonById = async (id) => {
  try {
    const response = await fetch(`${API_URL}/seasons/${id}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeasonById(${id}):`, error);
    throw error;
  }
};

export const getSeasonsBySeries = async (seriesId) => {
  try {
    const response = await fetch(`${API_URL}/seasons/series/${seriesId}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeasonsBySeries(${seriesId}):`, error);
    throw error;
  }
};

export const getSeasonsByType = async (type) => {
  try {
    const response = await fetch(`${API_URL}/seasons/type/${type}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeasonsByType(${type}):`, error);
    throw error;
  }
};

export const getSeasonBySeriesAndNumber = async (seriesId, seasonNumber) => {
  try {
    const response = await fetch(`${API_URL}/seasons/series/${seriesId}/season/${seasonNumber}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeasonBySeriesAndNumber(${seriesId}, ${seasonNumber}):`, error);
    throw error;
  }
};

export const getSeasonCountBySeries = async (seriesId) => {
  try {
    const response = await fetch(`${API_URL}/seasons/series/${seriesId}/count`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeasonCountBySeries(${seriesId}):`, error);
    throw error;
  }
};