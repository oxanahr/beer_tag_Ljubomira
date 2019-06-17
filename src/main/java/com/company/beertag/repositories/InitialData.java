package com.company.beertag.repositories;

import com.company.beertag.models.Beer;
import com.company.beertag.models.users.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class InitialData {
    private List<User> users;
    private List<Beer> beers;

    public InitialData(){
        users=new ArrayList<>();
       /* User u1=new User(1,"Ivan", UserType.USER,"1234");
        User u2=new User(2,"Peter", UserType.ADMINISTRATOR,"78910");
        User u3=new User(3,"Georgi", UserType.VISITOR,"56444");
        users.add(u1);
        users.add(u2);
        users.add(u3);
*/
        beers=new ArrayList<>();
        Beer b1=new Beer(1,"Zagorka");
        Beer b2=new Beer(2,"Kamenitza");
        Beer b3=new Beer(3,"Ariana");
        beers.add(b1);
        beers.add(b2);
        beers.add(b3);
        //todo maybe it will throw an exception because the list is not initialized -
        // ? solved in the Repository (if (user.getWishList()==null))
      /*  u1.setWishList(new HashSet<>());
        u1.getWishList().add(b1);
        u1.getWishList().add(b2);


        u2.setWishList(new HashSet<>());
        u2.getWishList().add(b2);


        u3.setWishList(new HashSet<>());
        u3.getWishList().add(b1);
        u3.getWishList().add(b2);
        u3.getWishList().add(b3);
*/

    }

    public List<User> getUsers() {
        return users;
    }

    public List<Beer> getBeers() {
        return beers;
    }
}
