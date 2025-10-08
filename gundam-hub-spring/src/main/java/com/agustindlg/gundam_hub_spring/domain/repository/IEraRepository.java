package com.agustindlg.gundam_hub_spring.domain.repository;

import com.agustindlg.gundam_hub_spring.domain.model.Era;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IEraRepository extends JpaRepository<Era, Long> {
    
    // Encontrar eras por universo, ordenadas cronológicamente
    List<Era> findByUniverseIdOrderByChronologicalOrder(Long universeId);
    
    // Encontrar eras canónicas por universo
    List<Era> findByUniverseIdAndIsCanonicalOrderByChronologicalOrder(Long universeId, Boolean isCanonical);
    
    // Encontrar era por nombre (útil para búsquedas)
    List<Era> findByNameContainingIgnoreCase(String name);
}