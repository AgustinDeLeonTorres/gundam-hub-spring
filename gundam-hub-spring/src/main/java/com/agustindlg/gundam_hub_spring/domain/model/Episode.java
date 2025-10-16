package com.agustindlg.gundam_hub_spring.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer episodeNumber;
    private Integer durationMinutes; 
    private String description;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    // Constructores
    public Episode() {}

    public Episode(String title, Integer episodeNumber, Integer durationMinutes, String description) {
        this.title = title;
        this.episodeNumber = episodeNumber;
        this.durationMinutes = durationMinutes;
        this.description = description;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getEpisodeNumber() { return episodeNumber; }
    public void setEpisodeNumber(Integer episodeNumber) { this.episodeNumber = episodeNumber; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Season getSeason() { return season; }
    public void setSeason(Season season) { this.season = season; }
}