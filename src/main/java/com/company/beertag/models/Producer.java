package com.company.beertag.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producers")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producerID")
    private int id;

    @Column(name = "brewery")
    private String brewery;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "producer")
    @JsonIgnore
    List<Beer> beers;

    public Producer() {
    }

    public Producer(int id, String brewery, String country) {
        this.id = id;
        this.brewery = brewery;
        this.country = country;
        this.beers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }
}
