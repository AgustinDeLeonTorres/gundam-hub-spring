package com.agustindlg.gundam_hub_spring.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Double duration; // en horas
    private Integer episodeNumber;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    // Constructores
    public Episode() {}

    public Episode(String title, Double duration, Integer episodeNumber) {
        this.title = title;
        this.duration = duration;
        this.episodeNumber = episodeNumber;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Double getDuration() { return duration; }
    public void setDuration(Double duration) { this.duration = duration; }

    public Integer getEpisodeNumber() { return episodeNumber; }
    public void setEpisodeNumber(Integer episodeNumber) { this.episodeNumber = episodeNumber; }

    public Series getSeries() { return series; }
    public void setSeries(Series series) { this.series = series; }
}