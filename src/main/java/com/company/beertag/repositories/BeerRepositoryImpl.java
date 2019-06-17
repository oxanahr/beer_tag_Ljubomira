package com.company.beertag.repositories;

import com.company.beertag.models.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BeerRepositoryImpl implements BeerRepository {
    List<Beer> beers;


    @Autowired
    public BeerRepositoryImpl() {
        InitialData data=new InitialData();
        beers=data.getBeers();
    }

    @Override
    public List<Beer> getAll() {
        return beers;
    }

    @Override
    public Beer getById(int id) {
        return beers.stream()
                .filter(beer -> beer.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Beer with ID %d does not exist!", id)));
    }

    @Override
    public Beer getByName(String name) {
        return beers.stream()
                .filter(beer -> beer.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Beer with name %s does not exist!", name)));

    }

    @Override
    public Beer create(Beer beer) {
        beers.add(beer);
        return beer;
    }

    @Override
    public void delete(int id) {
        beers.remove(getById(id));
    }
}
