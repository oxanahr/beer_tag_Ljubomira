package com.company.beertag.repositories;

import com.company.beertag.models.Beer;
import com.company.beertag.models.users.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("select u from User u", User.class);
        return query.list();
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }


    @Override
    public Set<Beer> getWishList(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("SELECT u FROM User u JOIN FETCH u.wishList WHERE u.id = :id", User.class);
        query.setParameter("id", id);
        User user = query.getSingleResult();
        return user.getWishList();

/*        TypedQuery<Beer> q = session.createQuery("SELECT b FROM Beer b JOIN FETCH b.users bu WHERE bu.id = :id", Beer.class);
        q.setParameter("ïd", id);
        q.setFirstResult(0);
        q.setMaxResults(5);
        List<Beer> u = q.getResultList();
        return user.getWishList();*/
    }

    @Override
    public List<User> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where name=:name", User.class);
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    public void create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }




  /*  @Override
    public void delete(int id) {
        users.remove(getById(id));
    }

    @Override
    public User update(int id, String newPassword) {
        User user = getById(id);
        user.setPassword(newPassword);
        return user;
    }

    @Override
    public User addBeer(int id, Beer beer) {
        User user = getById(id);
        if (user.getWishList() == null) {
            user.setWishList(new HashSet<>());
        }
        user.getWishList().add(beer);
        beers.add(beer);
        return user;
    }

    @Override
    public User add(User user) {
        users.add(user);
        return user;
    }*/
}
