package com.agustindlg.gundam_hub_spring.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eras")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Era {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "chronological_order", nullable = false)
    private Integer chronologicalOrder;

    @Column(name = "is_canonical")
    private Boolean isCanonical = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "universe_id")
    @JsonIgnoreProperties({"series", "eras"})
    private Universe universe;

    @OneToMany(mappedBy = "era", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Series> series = new ArrayList<>();

    // Constructores
    public Era() {}

    public Era(String name, String description, Integer chronologicalOrder, Boolean isCanonical) {
        this.name = name;
        this.description = description;
        this.chronologicalOrder = chronologicalOrder;
        this.isCanonical = isCanonical;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getChronologicalOrder() { return chronologicalOrder; }
    public void setChronologicalOrder(Integer chronologicalOrder) { this.chronologicalOrder = chronologicalOrder; }

    public Boolean getIsCanonical() { return isCanonical; }
    public void setIsCanonical(Boolean isCanonical) { this.isCanonical = isCanonical; }

    public Universe getUniverse() { return universe; }
    public void setUniverse(Universe universe) { this.universe = universe; }

    public List<Series> getSeries() { return series; }
    public void setSeries(List<Series> series) { this.series = series; }
}