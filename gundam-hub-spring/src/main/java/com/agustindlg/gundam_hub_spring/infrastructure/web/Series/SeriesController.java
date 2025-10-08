package com.agustindlg.gundam_hub_spring.infrastructure.web.Series;

import com.agustindlg.gundam_hub_spring.application.service.ISeriesService;
import com.agustindlg.gundam_hub_spring.domain.model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/series")
@CrossOrigin(origins = "http://localhost:5173") // ✅ AGREGAR CORS
public class SeriesController {

    private final ISeriesService seriesService;

    @Autowired
    public SeriesController(ISeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping
    public List<Series> getAllSeries() {
        return seriesService.getAllSeries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Series> getSeriesById(@PathVariable Long id) {
        Optional<Series> series = seriesService.getSeriesById(id);
        return series.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ NUEVO ENDPOINT: Series por Universe ID
    @GetMapping("/universe/{universeId}")
    public List<Series> getSeriesByUniverse(@PathVariable Long universeId) {
        return seriesService.findByUniverseId(universeId);
    }

    // ✅ NUEVO ENDPOINT: Series por Era ID  
    @GetMapping("/era/{eraId}")
    public List<Series> getSeriesByEra(@PathVariable Long eraId) {
        return seriesService.findByEraId(eraId);
    }

    @PostMapping
    public Series createSeries(@RequestBody Series series) {
        return seriesService.saveSeries(series);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeries(@PathVariable Long id) {
        seriesService.deleteSeries(id);
        return ResponseEntity.noContent().build();
    }
}