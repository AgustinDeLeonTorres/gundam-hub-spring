package com.agustindlg.gundam_hub_spring.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;

    @Column(name = "season_number", nullable = false)
    private Integer seasonNumber;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeasonType type;

    @Column(name = "hours_length")
    private Double hoursLength;

    @Column(name = "chronological_order")
    private Integer chronologicalOrder;

    @Column(name = "episode_count")
    private Integer episodeCount = 0;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum SeasonType {
        TV, MOVIE, OVA, SPECIAL, ONA
    }

    public Season() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Season(Long id, Series series, Integer seasonNumber, String title, 
                  String description, Integer releaseYear, SeasonType type, 
                  Double hoursLength, Integer chronologicalOrder, Integer episodeCount) {
        this();
        this.id = id;
        this.series = series;
        this.seasonNumber = seasonNumber;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.type = type;
        this.hoursLength = hoursLength;
        this.chronologicalOrder = chronologicalOrder;
        this.episodeCount = episodeCount;
    }

    // Getters y Setters COMPLETOS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Series getSeries() { return series; }
    public void setSeries(Series series) { this.series = series; }
    public Integer getSeasonNumber() { return seasonNumber; }
    public void setSeasonNumber(Integer seasonNumber) { this.seasonNumber = seasonNumber; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
    public SeasonType getType() { return type; }
    public void setType(SeasonType type) { this.type = type; }
    public Double getHoursLength() { return hoursLength; }
    public void setHoursLength(Double hoursLength) { this.hoursLength = hoursLength; }
    public Integer getChronologicalOrder() { return chronologicalOrder; }
    public void setChronologicalOrder(Integer chronologicalOrder) { this.chronologicalOrder = chronologicalOrder; }
    public Integer getEpisodeCount() { return episodeCount; }
    public void setEpisodeCount(Integer episodeCount) { this.episodeCount = episodeCount; }
    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}