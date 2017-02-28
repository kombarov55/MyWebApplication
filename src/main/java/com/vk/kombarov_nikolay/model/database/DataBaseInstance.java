package com.vk.kombarov_nikolay.model.database;

import com.mysql.cj.fabric.jdbc.FabricMySQLDataSource;
import com.vk.kombarov_nikolay.model.messenger.Message;
import com.vk.kombarov_nikolay.model.messenger.util.TableNameCreator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolaykombarov on 01.01.17.
 */

public class DataBaseInstance {
//    private static DataBaseInstance instance;
//
//    private static Logger logger = Logger.getLogger(DataBaseInstance.class);
//
//    private static DataSource ds;
//
//
//    private static String daoUsername, daoPassword, daoUrl;
//
//    private DataBaseInstance(String url, String username, String password) {
//        daoUrl = url;
//        daoUsername = username;
//        daoPassword = password;
//
//        logger.info("constructor with params was called");
//    }
//
//    private DataBaseInstance() {
//
//    }
//
//    public static DataBaseInstance getInstance() {
//        return instance;
//    }
//
//    public static void initConnectionPool(String url, String username, String password) throws SQLException, ClassNotFoundException {
//        if (instance != null)
//            return;
//        instance = new DataBaseInstance(url, username, password);
//        initDataSource();
//    }
//
//
//    public static void initConnectionPool() throws NamingException, SQLException {
//        InitialContext ic = new InitialContext();
//        ds = (DataSource) ic.lookup("java:/comp/env/jdbc/myDBTest");
//
//        logger.info("DBCP object was found in initial context");
//
//        //Проверка соединения
//        Connection con = ds.getConnection();
//        con.close();
//
//        instance = new DataBaseInstance();
//
//        logger.info("Connection pool was initialized");
//    }
//
//    private static void initDataSource() throws SQLException {
//        FabricMySQLDataSource dat = new FabricMySQLDataSource();
//        dat.setUser(daoUsername);
//        dat.setPassword(daoPassword);
//        dat.setURL(daoUrl);
//
//        ds = dat;
//
////        Проверка соединения
//        Connection con = dat.getConnection();
//        con.close();
//        logger.info("A single datasource was initialized by using parameters");
//
//
//        try {
//            Connection c = dat.getConnection();
//            Statement s = c.createStatement();
//            ResultSet rs = s.executeQuery("SELECT * FROM users");
//
//            rs.close();
//            s.close();
//            c.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addUser(String username, String password) throws SQLException {
//        String loginQuery = "" +
//                "INSERT INTO users(username, password)" +
//                "VALUES(?,?);";
//        String roleQuery = "" +
//                "INSERT INTO user_roles " +
//                "VALUES(?,?);";
//        try (Connection con = ds.getConnection()) {
//            con.setAutoCommit(false);
//            try (PreparedStatement ps1 = con.prepareStatement(loginQuery);
//                 PreparedStatement ps2 = con.prepareStatement(roleQuery)) {
//                ps1.setString(1, username);
//                ps1.setString(2, password);
//                ps1.execute();
//                ps2.setString(1, username);
//                ps2.setString(2, "member");
//                ps2.execute();
//
//                con.commit();
//                logger.info(String.format("User #%s was added to database", username));
//            } catch (SQLException e) {
//                con.rollback();
//                logger.error(String.format("Failed attempt to register user #%s", username), e);
//                throw e;
//            } finally {
//                con.setAutoCommit(true);
//            }
//        }
//
//    }
//
//    public void removeUser(String username) throws SQLException {
//        String query = "" +
//                "DELETE FROM users " +
//                "WHERE username=?;";
//        String removeRoleQuery = "" +
//                "DELETE FROM user_roles " +
//                "WHERE username=?;";
//        try (Connection con = ds.getConnection()) {
//            con.setAutoCommit(false);
//            try (PreparedStatement ps1 = con.prepareStatement(query);
//                 PreparedStatement ps2 = con.prepareStatement(removeRoleQuery)) {
//
//                ps1.setString(1, username);
//                ps1.execute();
//                ps2.setString(1, username);
//                ps2.execute();
//
//                con.commit();
//                logger.info(String.format("User #%s was removed", username));
//            } catch (SQLException e) {
//                con.rollback();
//                logger.error(String.format("Error while deleting user #%s", username), e);
//                throw e;
//            } finally {
//                con.setAutoCommit(true);
//            }
//        }
//    }
//
//    public boolean containsUser(String username) throws SQLException {
//        String query = "" +
//                "SELECT * FROM users " +
//                "WHERE username=?;";
//        try (Connection con = ds.getConnection();
//             PreparedStatement ps = con.prepareStatement(query)) {
//
//            ps.setString(1, username);
//
//            try (ResultSet rs = ps.executeQuery()) {
//                return rs.next();
//            }
//
//
//        }
//    }
//
//    public List<String> getUsernames() throws SQLException {
//        List<String> usernames = new ArrayList<>();
//        String query = "" +
//                "SELECT username FROM users;";
//        try (Connection con = ds.getConnection();
//             Statement statement = con.createStatement();
//             ResultSet rs = statement.executeQuery(query)) {
//            while (rs.next()) {
//                usernames.add(rs.getString("username"));
//            }
//            logger.info("Loading usernames list has succeeded");
//            return usernames;
//        }
//    }
//
//    public void changePassword(String username, String newPassword) throws SQLException {
//        String query = "" +
//                "SELECT * FROM users " +
//                "WHERE username=?;";
//        try (Connection con = ds.getConnection();
//             PreparedStatement ps = con.prepareCall(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
//
//            ps.setString(1, username);
//
//            try (ResultSet rs = ps.executeQuery()) {
//
//                while (rs.next()) {
//                    String rs_username = rs.getString("username");
//                    if (rs_username.equals(username)) {
//                        rs.updateString("password", newPassword);
//                        rs.updateRow();
//                        logger.info(String.format("User #%s has successfully changed his password", username));
//                    } else {
//                        logger.warn(String.format("User #%s not found while changing password", username));
//                        throw new SQLException("User #" + username + " not found");
//                    }
//                }
//            }
//
//        }
//    }
//
//    public boolean verify(String username, String password) throws SQLException {
//        boolean result = false;
//        String query =
//                "SELECT * FROM users " +
//                        "WHERE username=? AND password=?;";
//        try (Connection con = ds.getConnection();
//             PreparedStatement ps = con.prepareStatement(query)) {
//
//            ps.setString(1, username);
//            ps.setString(2, password);
//
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    String rs_username = rs.getString("username");
//                    String rs_password = rs.getString("password");
//
//                    if (username.equals(rs_username) && password.equals(rs_password))
//                        result = true;
//                }
//            }
//        }
//        return result;
//    }
//
//    public void createDialog(String username1, String username2) throws SQLException {
//        String dialogQuery = "" +
//                "INSERT INTO dialogs " +
//                "VALUES(?, ?, ? );";
//
//        String tableName = TableNameCreator.createTableName(username1, username2);
//
//        String dialogTableQuery = "" +
//                "CREATE TABLE myDBTest." + tableName + " " +
//                "(" +
//                "    date DATE DEFAULT NULL ," +
//                "    content VARCHAR(1000)" +
//                ");";
//
//
//        try (Connection con = ds.getConnection()) {
//            con.setAutoCommit(false);
//            try (PreparedStatement ps1 = con.prepareStatement(dialogQuery);
//                 Statement st2 = con.createStatement()) {
//
//                ps1.setString(1, tableName);
//                ps1.setString(2, username1);
//                ps1.setString(3, username2);
//                ps1.execute();
//                logger.info(String.format("A record about #%s was created in dialogs", tableName));
//
//                st2.execute(dialogTableQuery);
//                logger.info(String.format("Table #%s was created", tableName));
//
//                con.commit();
//            } catch (SQLException e) {
//                con.rollback();
//                logger.error("Error while creating dialog", e);
//                throw e;
//            } finally {
//                con.setAutoCommit(true);
//            }
//        }
//    }
//
//    public void removeDialogTable(String username1, String username2) throws SQLException {
//        String query = "" +
//                "DELETE FROM dialogs " +
//                "WHERE table_name=? OR table_name=?;";
//        try (Connection con = ds.getConnection();
//             PreparedStatement ps = con.prepareStatement(query)) {
//            String tableName1 = TableNameCreator.createTableName(username1, username2);
//            String tableName2 = TableNameCreator.createTableName(username2, username1);
//            ps.setString(1, tableName1);
//            ps.setString(2, tableName2);
//            ps.execute();
//
//
//            logger.info(String.format("A record about #%s was removed from dialogs", tableName1));
//            //TODO: нужно сначала узнать точное имя таблицы
//            try {
//                dropTable(tableName1);
//            } catch (SQLException e) {
//                dropTable(tableName2);
//            }
//        }
//    }
//
//    private void dropTable(String tableName) throws SQLException {
//        String query = "" +
//                "DROP TABLE " + tableName + ";";
//        try (Connection con = ds.getConnection();
//             Statement statement = con.createStatement()) {
//            statement.executeUpdate(query);
//        }
//    }
//
//    public List<String> getDialogTablenames() throws SQLException {
//        List<String> tableNames = new ArrayList<>();
//        String query = "" +
//                "SELECT table_name FROM dialogs;";
//        try (Connection con = ds.getConnection();
//             Statement statement = con.createStatement();
//             ResultSet rs = statement.executeQuery(query)) {
//            while (rs.next()) {
//                tableNames.add(rs.getString("table_name"));
//            }
//        }
//        logger.info("Dialog table names were successfully loaded");
//        return tableNames;
//    }
//
//    public void addMessage(String tableName, String content) throws SQLException {
//        String query = "" +
//                "INSERT INTO " + tableName + " " +
//                "VALUES(NOW(), ?);";
//
//        try (Connection con = ds.getConnection();
//             PreparedStatement ps = con.prepareStatement(query)) {
//
//            ps.setString(1, content);
//            ps.execute();
//            logger.info(String.format("message to #%s was sent", tableName));
//        }
//    }
//
//    public void removeMessage(String tableName, String content) throws SQLException {
//        String query = "" +
//                "DELETE FROM " + tableName + " " +
//                "WHERE content=?;";
//
//        try (Connection con = ds.getConnection();
//             PreparedStatement ps = con.prepareStatement(query)) {
//
//            ps.setString(1, content);
//            ps.execute();
//            logger.info(String.format("Message from #%s was removed", tableName));
//        }
//    }
//
//    public List<Message> loadMessages(String tableName) throws SQLException {
//        List<Message> messages = new ArrayList<>();
//        String query = "SELECT * FROM " + tableName + ";";
//
//        try (Connection con = ds.getConnection();
//             Statement statement = con.createStatement();
//             ResultSet rs = statement.executeQuery(query)) {
//
//            while (rs.next()) {
//                Date date = rs.getDate("date");
//                String content = rs.getString("content");
//                messages.add(new Message(date, content));
//            }
//        }
//        logger.info(String.format("Messages list from #%s were successfully loaded", tableName));
//        return messages;
//    }
//

}
