package com.agustindlg.gundam_hub_spring.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "universes")
public class Universe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "universe", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Series> series;

    // Constructores
    public Universe() {}

    public Universe(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Series> getSeries() { return series; }
    public void setSeries(List<Series> series) { this.series = series; }
}