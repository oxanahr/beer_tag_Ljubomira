package com.company.beertag.services;

import com.company.beertag.models.Beer;
import com.company.beertag.models.users.User;

import java.util.List;
import java.util.Set;

public interface UserService {

//    User add(User user);

 //   User addBeer(int id, Beer beer);

    //   Beer rate(Beer beer, int rating);

    List<User> getAll();

    Set<Beer> getAllBeers(int id);

//    void delete(int id);

  //  User update(int id, String newPassword);

    User getById(int id);

    // Beer delete(Beer beer);

    // Beer edit(Beer beer, String description);


}
