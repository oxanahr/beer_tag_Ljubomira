package com.company.beertag.repositories;

import com.company.beertag.models.Beer;
import com.company.beertag.models.users.User;

import java.util.List;
import java.util.Set;

public interface UserRepository {
    List<User> getAll();

    User getById(int id);

    List<User> getByName(String name);

    void create(User user);

  //  List<Beer> getAllBeers(int id);

     Set<Beer> getWishList(int id);

    /*void delete(int id);

    User update(int id, String newPassword);

    User addBeer(int id, Beer beer);

    User add(User user);*/
}
