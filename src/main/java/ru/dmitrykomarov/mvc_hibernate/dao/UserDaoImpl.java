/*
 * @author Dmitry Komarov
 * Created 15.06.2024
 */


package ru.dmitrykomarov.mvc_hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dmitrykomarov.mvc_hibernate.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser (User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(long id) {
        entityManager.createQuery("delete from User where id=:id").setParameter("id", id).executeUpdate();
    }


}
