package com.agustindlg.gundam_hub_spring.infrastructure.web.Era;

import com.agustindlg.gundam_hub_spring.domain.model.Era;
import com.agustindlg.gundam_hub_spring.domain.repository.IEraRepository;
import com.agustindlg.gundam_hub_spring.application.service.IEraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eras")
@CrossOrigin(origins = "http://localhost:5173")
public class EraController {

    private final IEraService eraService;

    @Autowired
    public EraController(IEraService eraService) {
        this.eraService = eraService;
    }

    // Obtener todas las eras
    @GetMapping
    public ResponseEntity<List<Era>> getAllEras() {
        try {
            List<Era> eras = eraService.findAll();
            return ResponseEntity.ok(eras);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener era por ID
    @GetMapping("/{id}")
    public ResponseEntity<Era> getEraById(@PathVariable Long id) {
        try {
            return eraService.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener eras por universo (para navegación)
    @GetMapping("/universe/{universeId}")
    public ResponseEntity<List<Era>> getErasByUniverse(@PathVariable Long universeId) {
        try {
            List<Era> eras = eraService.findByUniverseId(universeId);
            return ResponseEntity.ok(eras);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener solo eras canónicas por universo
    @GetMapping("/universe/{universeId}/canonical")
    public ResponseEntity<List<Era>> getCanonicalErasByUniverse(@PathVariable Long universeId) {
        try {
            List<Era> eras = eraService.findCanonicalByUniverseId(universeId);
            return ResponseEntity.ok(eras);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Buscar eras por nombre
    @GetMapping("/search")
    public ResponseEntity<List<Era>> searchEras(@RequestParam String name) {
        try {
            List<Era> eras = eraService.findByNameContaining(name);
            return ResponseEntity.ok(eras);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Crear nueva era
    @PostMapping
    public ResponseEntity<Era> createEra(@RequestBody Era era) {
        try {
            Era savedEra = eraService.save(era);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEra);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Actualizar era existente
    @PutMapping("/{id}")
    public ResponseEntity<Era> updateEra(@PathVariable Long id, @RequestBody Era eraDetails) {
        try {
            return eraService.findById(id)
                    .map(era -> {
                        era.setName(eraDetails.getName());
                        era.setDescription(eraDetails.getDescription());
                        era.setChronologicalOrder(eraDetails.getChronologicalOrder());
                        era.setIsCanonical(eraDetails.getIsCanonical());
                        Era updatedEra = eraService.save(era);
                        return ResponseEntity.ok(updatedEra);
                    })
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Eliminar era
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEra(@PathVariable Long id) {
        try {
            if (eraService.existsById(id)) {
                eraService.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}