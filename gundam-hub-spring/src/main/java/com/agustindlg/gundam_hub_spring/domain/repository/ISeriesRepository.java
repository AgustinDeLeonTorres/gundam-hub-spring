package com.agustindlg.gundam_hub_spring.domain.repository;

import com.agustindlg.gundam_hub_spring.domain.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findByUniverseId(Long universeId);
    
    // ✅ AGREGAR ESTE MÉTODO NUEVO:
    List<Series> findByEraId(Long eraId);
    
    Optional<Series> findByTitle(String title);
}