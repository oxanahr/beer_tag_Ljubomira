package com.company.beertag.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagID")
    private int id;

    @Column(name = "tag_name")
    private String tag;

    @ManyToMany(mappedBy = "tags")
    private List<Beer> beers;

    public Tag() {
    }

    public Tag(int id, String tag) {
        this.id = id;
        this.tag = tag;
        this.beers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }
}

