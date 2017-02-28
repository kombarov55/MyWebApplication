package com.vk.kombarov_nikolay.model.database;

import com.vk.kombarov_nikolay.model.messenger.Message;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nikolaykombarov on 26.01.17.
 */

@Component
public class MessageDao implements IMessageDao {

    private DataSource ds;

    public MessageDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void add(String tableName, Message message) throws SQLException {

        String query = "" +
                "INSERT INTO " + tableName + " " +
                "VALUES(NOW(), ?, ?);";

        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, message.getContent());
            ps.setString(2, message.getSender());
            ps.executeUpdate();
        }
    }

    @Override
    public void remove(String tableName, String content) throws SQLException {
        String query = "" +
                "DELETE FROM " + tableName + " " +
                "WHERE content=?;";

        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, content);
            ps.execute();
        }
    }

    @Override
    public Set<Message> getAllMessages(String tableName) throws SQLException {
        Set<Message> messages = new HashSet<>();
        String query = "SELECT * FROM " + tableName + ";";

        try (Connection con = ds.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                Date date = rs.getDate("date");
                String content = rs.getString("content");
                String sender = rs.getString("sender");
                messages.add(new Message(date, content, sender));
            }
        }
        return messages;
    }
}
