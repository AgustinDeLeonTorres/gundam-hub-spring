package com.agustindlg.gundam_hub_spring.domain.repository;

import com.agustindlg.gundam_hub_spring.domain.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISeriesRepository extends JpaRepository<Series, Long> {
    
    // ✅ CORREGIDO: Usar consultas @Query explícitas
    @Query("SELECT s FROM Series s WHERE s.universe.id = :universeId")
    List<Series> findByUniverseId(@Param("universeId") Long universeId);
    
    @Query("SELECT s FROM Series s WHERE s.era.id = :eraId")
    List<Series> findByEraId(@Param("eraId") Long eraId);
    
    Optional<Series> findByTitle(String title);
}