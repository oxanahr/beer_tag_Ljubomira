package com.company.beertag.services;

import com.company.beertag.models.Beer;
import com.company.beertag.models.users.User;
import com.company.beertag.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

   /* @Override
    public Beer add(Beer beer) {
        return null;
    }

    @Override
    public Beer rate(Beer beer, int rating) {
        return null;
    }*/

   /* @Override
    public User add(User user) {
        return repository.add(user);
    }

    @Override
    public User addBeer(int id, Beer beer) {
        return repository.addBeer(id, beer);
    }*/

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public Set<Beer> getAllBeers(int id) {
        return repository.getWishList(id);
    }

   /* @Override
    public void delete(int id) {
        try {
            repository.delete(id);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public User update(int id, String newPassword) {
        try {
            return repository.update(id, newPassword);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }*/

    @Override
    public User getById(int id) {
        try {
            return repository.getById(id);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


  /*  @Override
    public Beer delete(Beer beer) {
        return null;
    }

    @Override
    public Beer edit(Beer beer, String description) {
        return null;
    }
*/


}
