package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Era;
import java.util.List;
import java.util.Optional;

public interface IEraService {
    
    // Obtener todas las eras
    List<Era> findAll();
    
    // Obtener era por ID
    Optional<Era> findById(Long id);
    
    // Obtener eras por universo ID, ordenadas cronológicamente
    List<Era> findByUniverseId(Long universeId);
    
    // Obtener solo eras canónicas por universo
    List<Era> findCanonicalByUniverseId(Long universeId);
    
    // Buscar eras por nombre
    List<Era> findByNameContaining(String name);
    
    // Guardar o actualizar era
    Era save(Era era);
    
    // Eliminar era por ID
    void deleteById(Long id);
    
    // Verificar si existe era por ID
    boolean existsById(Long id);
}