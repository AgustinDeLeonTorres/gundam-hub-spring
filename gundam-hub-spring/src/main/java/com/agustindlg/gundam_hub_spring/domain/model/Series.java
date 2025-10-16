package com.agustindlg.gundam_hub_spring.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "series")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(name = "release_year")
    private Integer year;
    
    private String type;
    
    @Column(name = "hours_length")
    private Double hoursLength;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "universe_id")
    @JsonIgnoreProperties({"series", "eras"})
    private Universe universe;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "era_id")
    @JsonIgnoreProperties({"series", "universe"})
    private Era era;
    
    // RELACIÓN CON SEASONS
    @OneToMany(mappedBy = "series", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Season> seasons = new ArrayList<>();
    
    // CONSTRUCTORES (mantener igual)
    public Series() {}
    
    public Series(String title, Integer year, String type, Double hoursLength) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.hoursLength = hoursLength;
    }
    
    // GETTERS Y SETTERS (mantener)
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
    
    public Era getEra() { return era; }
    public void setEra(Era era) { this.era = era; }
    
    public List<Season> getSeasons() { return seasons; }
    public void setSeasons(List<Season> seasons) { this.seasons = seasons; }
    
    
    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", hoursLength=" + hoursLength +
                '}';
    }
}