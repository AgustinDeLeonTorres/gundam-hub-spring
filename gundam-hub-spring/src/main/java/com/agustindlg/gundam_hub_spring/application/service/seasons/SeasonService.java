package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Season;
import com.agustindlg.gundam_hub_spring.domain.repository.ISeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService implements ISeasonService {

    @Autowired
    private ISeasonRepository seasonRepository;

    @Override
    public List<Season> findAll() {
        return seasonRepository.findAll();
    }

    @Override
    public Season findById(Long id) {
        Optional<Season> season = seasonRepository.findById(id);
        return season.orElse(null);
    }

    @Override
    public List<Season> findBySeriesId(Long seriesId) {
        return seasonRepository.findBySeriesIdOrderByChronologicalOrderAsc(seriesId);
    }

    @Override
    public List<Season> findByType(Season.SeasonType type) {
        return seasonRepository.findByType(type);
    }

    @Override
    public Season findBySeriesIdAndSeasonNumber(Long seriesId, Integer seasonNumber) {
        return seasonRepository.findBySeriesIdAndSeasonNumber(seriesId, seasonNumber);
    }

    @Override
    public Season save(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public void deleteById(Long id) {
        seasonRepository.deleteById(id);
    }

    @Override
    public Long countBySeriesId(Long seriesId) {
        return seasonRepository.countBySeriesId(seriesId);
    }

    @Override
    public boolean existsById(Long id) {
        return seasonRepository.existsById(id);
    }
}