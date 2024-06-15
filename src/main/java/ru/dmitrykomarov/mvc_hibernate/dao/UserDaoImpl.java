/*
 * @author Dmitry Komarov
 * Created 15.06.2024
 */


package ru.dmitrykomarov.mvc_hibernate.dao;

import org.springframework.stereotype.Repository;
import ru.dmitrykomarov.mvc_hibernate.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private List<User> userList;
    {
        userList = new ArrayList<>();
        userList.add(new User(1, "Vika", "Karter"));
        userList.add(new User(2, "Kir", "Rrr"));
        userList.add(new User(3, "Roms", "Kder"));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(long id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
