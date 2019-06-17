package com.company.beertag.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "styles")
public class StyleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="styleID")
    private int id;

    @Column(name = "style_name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "style")
    private List<Beer> beers;

    public StyleType() {

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

    /*LIGHT,
    DARK;

    @Override
    public String toString(){
        switch (this){
            case DARK:
                return "Dark";
            case LIGHT:
                return "Light";
            default:
                    throw new IllegalArgumentException("There is no such style for a beer!");
        }
    }*/
}
