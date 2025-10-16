package com.agustindlg.gundam_hub_spring.infrastructure.web.Season;

import com.agustindlg.gundam_hub_spring.application.service.ISeasonService;
import com.agustindlg.gundam_hub_spring.domain.model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seasons")
@CrossOrigin(origins = "http://localhost:5173")
public class SeasonController {

    @Autowired
    private ISeasonService seasonService;

    @GetMapping
    public ResponseEntity<List<Season>> getAllSeasons() {
        List<Season> seasons = seasonService.findAll();
        return ResponseEntity.ok(seasons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable Long id) {
        Season season = seasonService.findById(id);
        if (season != null) {
            return ResponseEntity.ok(season);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/series/{seriesId}")
    public ResponseEntity<List<Season>> getSeasonsBySeries(@PathVariable Long seriesId) {
        List<Season> seasons = seasonService.findBySeriesId(seriesId);
        return ResponseEntity.ok(seasons);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Season>> getSeasonsByType(@PathVariable String type) {
        try {
            Season.SeasonType seasonType = Season.SeasonType.valueOf(type.toUpperCase());
            List<Season> seasons = seasonService.findByType(seasonType);
            return ResponseEntity.ok(seasons);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/series/{seriesId}/season/{seasonNumber}")
    public ResponseEntity<Season> getSeasonBySeriesAndNumber(
            @PathVariable Long seriesId, 
            @PathVariable Integer seasonNumber) {
        Season season = seasonService.findBySeriesIdAndSeasonNumber(seriesId, seasonNumber);
        if (season != null) {
            return ResponseEntity.ok(season);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/series/{seriesId}/count")
    public ResponseEntity<Long> getSeasonCountBySeries(@PathVariable Long seriesId) {
        Long count = seasonService.countBySeriesId(seriesId);
        return ResponseEntity.ok(count);
    }
}