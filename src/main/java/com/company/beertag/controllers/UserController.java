package com.company.beertag.controllers;

import com.company.beertag.models.Beer;
import com.company.beertag.models.users.User;
import com.company.beertag.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @GetMapping("/{id}/beers")
    public Set<Beer> getAllBeers(@PathVariable int id) {
        try {
            return service.getAllBeers(id);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
/*

    @PostMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody String password) {
        try {
            return service.update(id, password);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        try {
            service.delete(id);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/{id}/newBeer")
    public User addBeer(@PathVariable int id, @RequestBody Beer beer) {
        try {
            return service.addBeer(id, beer);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping
    public User addUser(@Valid @RequestBody User user) {
        return service.add(user);
    }
*/

}
