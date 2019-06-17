package com.company.beertag.services;

import com.company.beertag.models.Beer;
import com.company.beertag.models.StyleType;
import com.company.beertag.models.Tag;
import com.company.beertag.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerServiceImpl implements BeerService {
    BeerRepository repository;

    @Autowired
    public BeerServiceImpl(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Beer> getAll() {
        return repository.getAll();
    }

    @Override
    public Beer getById(int id) {
        try {
            return repository.getById(id);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Beer getByName(String name) {
        try {
        return repository.getByName(name);
    }catch (RuntimeException ex){
        throw new RuntimeException(ex.getMessage());
    }
    }

    @Override
    public Beer create(Beer beer) {
       return repository.create(beer);
    }

    @Override
    public List<Beer> sort(String property) {
       if (property.equals("rating")) {
           return repository.getAll().stream()
                   .sorted(Comparator.comparing(Beer::getRating))
                   .collect(Collectors.toList());
       }
        if (property.equals("ABV")) {
            return repository.getAll().stream()
                    .sorted(Comparator.comparing(Beer::getABV))
                    .collect(Collectors.toList());
        }
        if (property.equals("name")){
            return repository.getAll().stream()
                    .sorted(Comparator.comparing(Beer::getName))
                    .collect(Collectors.toList());
        }
        throw new RuntimeException(String.format("Beers cannot be sorted by %s",property));

    }
    @Override
    public List<Beer> getByTag(Tag tag) {
        return null;
    }

    @Override
    public List<Beer> getByStyle(StyleType styleType) {
        return null;
    }

    @Override
    public List<Beer> getByCountry(String country) {
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            repository.delete(id);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
