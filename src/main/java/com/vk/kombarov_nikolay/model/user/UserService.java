package com.vk.kombarov_nikolay.model.user;

import com.vk.kombarov_nikolay.model.database.Dao;
import com.vk.kombarov_nikolay.model.messenger.Dialog;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by nikolaykombarov on 25.01.17.
 */
public interface UserService {
    List<User> lookupUsers(Map<String, String> params) throws SQLException;

    User getUser(String username)throws SQLException;

    void addUser(User user) throws SQLException;

    boolean verifyUser(User user) throws SQLException;

    boolean validateUser(User user);

    void makeFriends(User user1, User user2);

}
