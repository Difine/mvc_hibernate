/*
 * @author Dmitry Komarov
 * Created 15.06.2024
 */


package ru.dmitrykomarov.mvc_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitrykomarov.mvc_hibernate.dao.UserDao;
import ru.dmitrykomarov.mvc_hibernate.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }
}
