package com.vk.kombarov_nikolay.model.user;

import com.vk.kombarov_nikolay.model.database.Dao;
import com.vk.kombarov_nikolay.model.user.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by nikolaykombarov on 04.01.17.
 */
@Component
public class UserServiceImpl implements UserService {

    @Qualifier("UserDao")
    private Dao<User> userDao;

    @Autowired
    public UserServiceImpl(Dao<User> userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> lookupUsers(Map<String, String> params) throws SQLException {
        return userDao.lookup(params);
    }

    @Override
    public void addUser(User user) throws SQLException {
        userDao.add(user);
    }


    @Override
    public void makeFriends(User user1, User user2) {
        user1.getFriendList().add(user2);
        user2.getFriendList().add(user1);
    }

    @Override
    public User getUser(String username) throws SQLException {
        return userDao.get(username);
    }

    @Override
    public boolean verifyUser(User user) throws SQLException {
        User storedUser = userDao.get(user.getUsername());
        return storedUser != null
                && storedUser.getPassword().equals(user.getPassword())
                && storedUser.getUsername().equals(user.getUsername());
    }

    @Override
    public boolean validateUser(User user) {
        return Validator.validate(user.getUsername(), user.getPassword());
    }
}

