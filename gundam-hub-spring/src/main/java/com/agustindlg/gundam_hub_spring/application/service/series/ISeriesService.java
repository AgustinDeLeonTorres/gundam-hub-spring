package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Series;
import java.util.List;
import java.util.Optional;

public interface ISeriesService {
    List<Series> getAllSeries();
    
    // ✅ AGREGAR ESTOS MÉTODOS NUEVOS:
    List<Series> findByEraId(Long eraId);
    List<Series> findByUniverseId(Long universeId);
    
    Optional<Series> getSeriesById(Long id);
    Series saveSeries(Series series);
    void deleteSeries(Long id);
}