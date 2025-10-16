package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Season;
import java.util.List;

public interface ISeasonService {
    List<Season> findAll();
    Season findById(Long id);
    List<Season> findBySeriesId(Long seriesId);
    List<Season> findByType(Season.SeasonType type);
    Season findBySeriesIdAndSeasonNumber(Long seriesId, Integer seasonNumber);
    Season save(Season season);
    void deleteById(Long id);
    Long countBySeriesId(Long seriesId);
    boolean existsById(Long id);
}