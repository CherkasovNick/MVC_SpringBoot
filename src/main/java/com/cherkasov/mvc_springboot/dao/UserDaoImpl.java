package com.cherkasov.mvc_springboot.dao;

import com.cherkasov.mvc_springboot.models.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getOne(Long id) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public User update(User updatedUser) {
        return entityManager.merge(updatedUser);
    }

    @Override
    public void delete(Long id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
    }

    @Override
    public User getUserByUsername(String name) {
        Query query = entityManager.createQuery("select distinct u from User u LEFT JOIN FETCH u.roles where u.name =:name");
        query.setParameter("name", name);
        User user = (User) query.getSingleResult();
        return entityManager.find(User.class, user.getId());
    }
}
