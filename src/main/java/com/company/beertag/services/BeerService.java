package com.company.beertag.services;

import com.company.beertag.models.Beer;
import com.company.beertag.models.StyleType;
import com.company.beertag.models.Tag;

import java.util.List;

public interface BeerService {
    List<Beer> getAll();

    Beer getById(int id);

    Beer getByName(String name);

    Beer create(Beer beer);

    List<Beer> sort(String property);


    List<Beer> getByTag(Tag tag);

    List<Beer> getByStyle(StyleType styleType);

    List<Beer> getByCountry(String country);

    void delete(int id);

}
