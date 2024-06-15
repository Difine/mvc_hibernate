package ru.dmitrykomarov.mvc_hibernate.service;

import ru.dmitrykomarov.mvc_hibernate.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
}
