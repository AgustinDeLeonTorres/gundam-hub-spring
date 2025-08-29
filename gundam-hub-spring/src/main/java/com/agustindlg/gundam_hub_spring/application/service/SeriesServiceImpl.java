package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Series;
import com.agustindlg.gundam_hub_spring.domain.repository.ISeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesServiceImpl implements ISeriesService {

    private final ISeriesRepository seriesRepository;

    @Autowired
    public SeriesServiceImpl(ISeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public Optional<Series> getSeriesById(Long id) {
        return seriesRepository.findById(id);
    }

    @Override
    public Series saveSeries(Series series) {
        return seriesRepository.save(series);
    }

    @Override
    public void deleteSeries(Long id) {
        seriesRepository.deleteById(id);
    }
}