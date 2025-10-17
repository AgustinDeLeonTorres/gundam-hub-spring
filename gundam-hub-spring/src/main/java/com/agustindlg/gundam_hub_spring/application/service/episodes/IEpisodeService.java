package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Episode;
import java.util.List;
import java.util.Optional;

public interface IEpisodeService {
    List<Episode> getAllEpisodes();
    List<Episode> findBySeasonId(Long seasonId);
    Optional<Episode> getEpisodeById(Long id);
    Episode saveEpisode(Episode episode);
    void deleteEpisode(Long id);
}