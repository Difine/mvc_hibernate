package ru.dmitrykomarov.mvc_hibernate.dao;

import ru.dmitrykomarov.mvc_hibernate.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUserById(long id);
    void saveUser(User user);



}
