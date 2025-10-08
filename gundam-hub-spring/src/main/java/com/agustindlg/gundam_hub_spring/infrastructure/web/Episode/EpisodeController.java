package com.agustindlg.gundam_hub_spring.infrastructure.web.Episode;

import com.agustindlg.gundam_hub_spring.application.service.IEpisodeService;
import com.agustindlg.gundam_hub_spring.domain.model.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/episodes")
@CrossOrigin(origins = "http://localhost:5173") // ✅ AGREGAR CORS
public class EpisodeController {

    private final IEpisodeService episodeService;

    @Autowired
    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public List<Episode> getAllEpisodes() {
        return episodeService.getAllEpisodes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Episode> getEpisodeById(@PathVariable Long id) {
        Optional<Episode> episode = episodeService.getEpisodeById(id);
        return episode.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ NUEVO ENDPOINT: Episodios por Series ID
    @GetMapping("/series/{seriesId}")
    public List<Episode> getEpisodesBySeries(@PathVariable Long seriesId) {
        return episodeService.findBySeriesId(seriesId);
    }

    @PostMapping
    public Episode createEpisode(@RequestBody Episode episode) {
        return episodeService.saveEpisode(episode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisode(@PathVariable Long id) {
        episodeService.deleteEpisode(id);
        return ResponseEntity.noContent().build();
    }
}