package com.company.beertag.models;

import com.company.beertag.models.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "beers")
public class Beer {// implements Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beerID")
    private int id;

    @Column(name = "beer_name")
    @Size(min = 1, max = 50, message = "Beer name should be between 1 and 50 symbols!")
    private String name;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "producerID")
    private Producer producer;

    @Column(name = "ABV")
    private double ABV;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "styleID")
    private StyleType style;

    private static double rating;

    private boolean status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "beers_tags",
            joinColumns = @JoinColumn(name = "beerID"),
            inverseJoinColumns = @JoinColumn(name = "tagID"))
    private Set<Tag> tags;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "wishList")
    @JsonIgnore
    private List<User> users;


    public Beer() {
    }

    public Beer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public double getABV() {
        return ABV;
    }

    public void setABV(double ABV) {
        this.ABV = ABV;
    }

    public StyleType getStyle() {
        return style;
    }

    public void setStyle(StyleType style) {
        this.style = style;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

   /* @Override
    public String toString() {
        return name;
    }
*/
/*    @Override
    public int compareTo(Object o) {
        Beer beer = (Beer) o;
        return beer.getRating() > rating ? 1 : -1;
    }*/
}
