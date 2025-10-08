package com.agustindlg.gundam_hub_spring.domain.repository;

import com.agustindlg.gundam_hub_spring.domain.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Long> {
    
    // ✅ AGREGAR ESTE MÉTODO NUEVO:
    List<Episode> findBySeriesId(Long seriesId);
}