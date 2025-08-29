package com.agustindlg.gundam_hub_spring.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "release_year")
    private Integer year;

    private String type; // TV, OVA, Movie

    @Column(name = "hours_length")
    private Double hoursLength;

    @ManyToOne
    @JoinColumn(name = "universe_id")
    private Universe universe;

    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL)
    @JsonIgnore //
    private List<Episode> episodes;

    // Constructores
    public Series() {}

    public Series(String title, Integer year, String type, Double hoursLength) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.hoursLength = hoursLength;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getHoursLength() { return hoursLength; }
    public void setHoursLength(Double hoursLength) { this.hoursLength = hoursLength; }

    public Universe getUniverse() { return universe; }
    public void setUniverse(Universe universe) { this.universe = universe; }

    public List<Episode> getEpisodes() { return episodes; }
    public void setEpisodes(List<Episode> episodes) { this.episodes = episodes; }
}