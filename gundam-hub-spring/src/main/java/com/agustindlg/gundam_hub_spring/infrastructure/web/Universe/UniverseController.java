package com.agustindlg.gundam_hub_spring.infrastructure.web.Universe;

import com.agustindlg.gundam_hub_spring.application.service.IUniverseService;
import com.agustindlg.gundam_hub_spring.domain.model.Universe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/universes")
public class UniverseController {

    private final IUniverseService universeService;

    @Autowired
    public UniverseController(IUniverseService universeService) {
        this.universeService = universeService;
    }

    @GetMapping
    public List<Universe> getAllUniverses() {
        return universeService.getAllUniverses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universe> getUniverseById(@PathVariable Long id) {
        Optional<Universe> universe = universeService.getUniverseById(id);
        return universe.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Universe createUniverse(@RequestBody Universe universe) {
        return universeService.saveUniverse(universe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniverse(@PathVariable Long id) {
        universeService.deleteUniverse(id);
        return ResponseEntity.noContent().build();
    }
}