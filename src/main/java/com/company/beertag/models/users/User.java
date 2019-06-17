package com.company.beertag.models.users;

import com.company.beertag.models.Beer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int id;

    @Column(name = "user_name")
    @Size(min = 1, max = 50, message = "Name length should be between 1 and 50 symbols!")
    private String name;


    @Column(name = "password")
    @Size(min = 1, max = 25, message = "Password length should be between 1 and 25 symbols!")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_beers",
            joinColumns = @JoinColumn(name = "userID"),
            inverseJoinColumns = @JoinColumn(name = "beerID"))
    @JsonIgnore
    private Set<Beer> wishList;

   /* @ManyToOne
    @JoinColumn(name = "typeID")
    @JsonIgnore
    private UserType userType;
*/
    public User() {
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
      //  this.userType = userType;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Beer> getWishList() {
        return wishList;
    }

    public void setWishList(Set<Beer> wishList) {
        this.wishList = wishList;
    }

  /*  public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
