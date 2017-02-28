package com.vk.kombarov_nikolay.model.database;

import com.vk.kombarov_nikolay.model.database.util.SqlRequestBuilder;
import com.vk.kombarov_nikolay.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by nikolaykombarov on 26.01.17.
 */

@Component
@Qualifier("UserDao")
public class UserDao implements Dao<User> {

    private static final String sqlAdd = "" +
            "INSERT INTO users " +
            "VALUES(?,?);";

    private static final String sqlAddRole = "" +
            "INSERT INTO user_roles " +
            "VALUES(?, 'member');";

    private static final String sqlRemove = "" +
            "DELETE FROM users " +
            "WHERE username=?";

    private static final String sqlRemoveRole = "" +
            "DELETE FROM user_roles " +
            "WHERE username=?";

    private static final String sqlUpdate = "" +
            "UPDATE users " +
            "SET password=? " +
            "WHERE username=?;";

    private static final String sqlGet = "" +
            "SELECT password " +
            "FROM users " +
            "WHERE username=?;";

    private static final String sqlGetAll = "" +
            "SELECT username " +
            "FROM users";

    protected DataSource ds;

    @Autowired
    public UserDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void add(User user) throws SQLException {
        try (Connection con = ds.getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement psUser = con.prepareStatement(sqlAdd);
                 PreparedStatement psRole = con.prepareStatement(sqlAddRole)) {

                psUser.setString(1, user.getUsername());
                psUser.setString(2, user.getPassword());
                psUser.executeUpdate();

                psRole.setString(1, user.getUsername());
                psRole.executeUpdate();

                con.commit();

            } catch (SQLException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    @Override
    public void remove(String primaryKey) throws SQLException {
        try (Connection con = ds.getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement psUser = con.prepareStatement(sqlRemove);
                 PreparedStatement psRole = con.prepareStatement(sqlRemoveRole)) {

                psUser.setString(1, primaryKey);
                psUser.executeUpdate();

                psRole.setString(1, primaryKey);
                psRole.executeUpdate();

                con.commit();

            } catch (SQLException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    @Override
    public void update(String primaryKey, Map<String, String> params) throws SQLException {
        String sql = SqlRequestBuilder.buildUpdate("UPDATE users ",
                "username=?", params.keySet());
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            SqlRequestBuilder.insertUpdateParams(ps, primaryKey, params);

            ps.executeUpdate();
        }
    }

    @Override
    public User get(String primaryKey) throws SQLException {
        User ret = null;
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlGet)) {

            ps.setString(1, primaryKey);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ret = new User();
                    ret.setUsername(primaryKey);
                    ret.setPassword(rs.getString("password"));
                }
            }
        }
        return ret;
    }

    @Override
    public List<User> lookup(Map<String, String> params) throws SQLException {
        List<User> result = new ArrayList<>();

        String sql;

        if (params == null)
            sql = "SELECT username, password FROM users ";
        else
        sql = SqlRequestBuilder.buildRequest("SELECT username, password FROM users", params.keySet());

        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            SqlRequestBuilder.insertParams(ps, params);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    result.add(user);
                }
            }
        }
        return result;
    }

}
