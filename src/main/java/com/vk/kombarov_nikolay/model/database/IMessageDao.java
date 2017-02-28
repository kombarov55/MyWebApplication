package com.vk.kombarov_nikolay.model.database;

import com.vk.kombarov_nikolay.model.messenger.Message;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by nikolaykombarov on 26.01.17.
 */
public interface IMessageDao {

    void add(String tableName, Message message) throws SQLException;

    void remove(String tableName, String content) throws SQLException;

    Set<Message> getAllMessages(String tableName) throws SQLException;

}
