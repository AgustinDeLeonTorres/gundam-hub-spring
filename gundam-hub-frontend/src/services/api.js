// src/services/api.js - VERSIÓN CORREGIDA
const API_URL = 'http://localhost:8080/api';

// Servicio para Universos
export const getUniverses = async () => {
  try {
    console.log('🌌 Haciendo petición a:', `${API_URL}/universes`);
    const response = await fetch(`${API_URL}/universes`);
    
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status}`);
    }
    
    const data = await response.json();
    console.log('✅ Universos recibidos:', data);
    return data;
  } catch (error) {
    console.error('❌ Error en getUniverses:', error);
    throw error;
  }
};

// Servicio para Eras
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

// Servicio para Series
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

// Servicio para Eras por Universo
export const getErasByUniverse = async (universeId) => {
  try {
    const response = await fetch(`${API_URL}/eras/universe/${universeId}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getErasByUniverse para universo ${universeId}:`, error);
    throw error;
  }
};

// Servicio para Series por Era
export const getSeriesByEra = async (eraId) => {
  try {
    const response = await fetch(`${API_URL}/series/era/${eraId}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeriesByEra para era ${eraId}:`, error);
    throw error;
  }
};

// Servicio para Series por Universo
export const getSeriesByUniverse = async (universeId) => {
  try {
    const response = await fetch(`${API_URL}/series/universe/${universeId}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeriesByUniverse para universo ${universeId}:`, error);
    throw error;
  }
};

// Servicio para Universo por ID
export const getUniverseById = async (id) => {
  try {
    const response = await fetch(`${API_URL}/universes/${id}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getUniverseById para ID ${id}:`, error);
    throw error;
  }
};

// Servicio para Era por ID
export const getEraById = async (id) => {
  try {
    const response = await fetch(`${API_URL}/eras/${id}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getEraById para ID ${id}:`, error);
    throw error;
  }
};

// Servicio para Serie por ID
export const getSeriesById = async (id) => {
  try {
    const response = await fetch(`${API_URL}/series/${id}`);
    if (!response.ok) throw new Error(`Error HTTP: ${response.status}`);
    return await response.json();
  } catch (error) {
    console.error(`❌ Error en getSeriesById para ID ${id}:`, error);
    throw error;
  }
};

// Exportar todo como objeto también (para compatibilidad)
export default {
  getUniverses,
  getEras,
  getSeries,
  getErasByUniverse,
  getSeriesByEra,
  getSeriesByUniverse,
  getUniverseById,
  getEraById,
  getSeriesById
};