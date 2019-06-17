package com.company.beertag.repositories;

import com.company.beertag.models.Beer;

import java.util.List;

public interface BeerRepository {
    List<Beer> getAll();

    Beer getById(int id);

    Beer getByName(String name);

    Beer create(Beer beer);

    void delete(int id);
}
