package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Series;
import java.util.List;
import java.util.Optional;

public interface ISeriesService {
    List<Series> getAllSeries();
    Optional<Series> getSeriesById(Long id);
    Series saveSeries(Series series);
    void deleteSeries(Long id);
}