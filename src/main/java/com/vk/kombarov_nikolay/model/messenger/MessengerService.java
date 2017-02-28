package com.vk.kombarov_nikolay.model.messenger;

import com.vk.kombarov_nikolay.model.database.Dao;
import com.vk.kombarov_nikolay.model.database.IMessageDao;
import com.vk.kombarov_nikolay.model.user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by nikolaykombarov on 25.01.17.
 */
public interface MessengerService {

    Dialog getDialog(String tableName) throws SQLException;

    List<Dialog> lookupDialogs(String username) throws SQLException;

    void sendMessage(User sender, String tableName, String content) throws SQLException;

    Dialog createDialog(String username1, String username2) throws SQLException;

}
