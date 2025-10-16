package com.agustindlg.gundam_hub_spring.domain.repository;

import com.agustindlg.gundam_hub_spring.domain.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeasonRepository extends JpaRepository<Season, Long> {
    List<Season> findBySeriesId(Long seriesId);
    List<Season> findByType(Season.SeasonType type);
    List<Season> findBySeriesIdOrderByChronologicalOrderAsc(Long seriesId);
    Season findBySeriesIdAndSeasonNumber(Long seriesId, Integer seasonNumber);
    
    @Query("SELECT COUNT(s) FROM Season s WHERE s.series.id = :seriesId")
    Long countBySeriesId(@Param("seriesId") Long seriesId);
}