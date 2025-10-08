package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Episode;
import com.agustindlg.gundam_hub_spring.domain.repository.IEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeServiceImpl implements IEpisodeService {

    private final IEpisodeRepository episodeRepository;

    @Autowired
    public EpisodeServiceImpl(IEpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }

    // ✅ NUEVO MÉTODO: Buscar episodios por Series ID
    @Override
    public List<Episode> findBySeriesId(Long seriesId) {
        return episodeRepository.findBySeriesId(seriesId);
    }

    @Override
    public Optional<Episode> getEpisodeById(Long id) {
        return episodeRepository.findById(id);
    }

    @Override
    public Episode saveEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    @Override
    public void deleteEpisode(Long id) {
        episodeRepository.deleteById(id);
    }
}