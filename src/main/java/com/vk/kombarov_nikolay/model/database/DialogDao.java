package com.vk.kombarov_nikolay.model.database;

import com.vk.kombarov_nikolay.model.database.util.SqlRequestBuilder;
import com.vk.kombarov_nikolay.model.messenger.Dialog;
import com.vk.kombarov_nikolay.model.messenger.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by nikolaykombarov on 26.01.17.
 */
@Component
@Qualifier("DialogDao")
public class DialogDao implements Dao<Dialog> {

    private DataSource ds;

    @Autowired
    private IMessageDao messageDao;

    public DialogDao(DataSource ds) {
        this.ds = ds;
    }

    private static final String sqlAdd = "" +
            "INSERT INTO dialogs " +
            "VALUES(?,?,?);";

    private static final String sqlRemoveDialog = "" +
            "DELETE FROM dialogs " +
            "WHERE table_name=?";

    @Override
    public void add(Dialog dialog) throws SQLException {
        String tableName = dialog.getTableName();

        String dialogTableQuery = "" +
                "CREATE TABLE myDBTest." + tableName + " " +
                "(" +
                "    date DATE DEFAULT NULL ," +
                "    content VARCHAR(1000), " +
                "    sender VARCHAR(16) DEFAULT null" +
                ");";

        try (Connection con = ds.getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement ps1 = con.prepareStatement(sqlAdd);
                 Statement st2 = con.createStatement()) {

                ps1.setString(1, tableName);
                ps1.setString(2, dialog.getUsername1());
                ps1.setString(3, dialog.getUsername2());
                ps1.execute();

                st2.execute(dialogTableQuery);

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
            try (PreparedStatement ps = con.prepareStatement(sqlRemoveDialog);
                 Statement st = con.createStatement()) {
                ps.setString(1, primaryKey);
                ps.execute();

                st.executeUpdate("DROP TABLE " + primaryKey + ";");

                con.commit();
            } catch (Exception e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    @Override
    public void update(String primaryKey, Map<String, String> params) throws SQLException {
        //do nothing
    }

    @Override
    public Dialog get(String tableName) throws SQLException {
        Dialog ret = new Dialog();

        Set<Message> messages = messageDao.getAllMessages(tableName);
        String[] names = tableName.split("_");

        ret.setUsername1(names[0]);
        ret.setUsername2(names[1]);
        ret.setMessages(messages);

        return ret;
    }

    //Здесь возвратит диалоги без сообщений
    @Override
    public List<Dialog> lookup(Map<String, String> params) throws SQLException {
        List<Dialog> ret = new ArrayList<>();
        String sql = SqlRequestBuilder.buildRequest("SELECT table_name, " +
                "username1, username2 FROM dialogs", params.keySet());
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            SqlRequestBuilder.insertParams(ps, params);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Dialog dialog = new Dialog();
                    dialog.setTableName(rs.getString("table_name"));
                    dialog.setUsername1(rs.getString("username1"));
                    dialog.setUsername2(rs.getString("username2"));
                    ret.add(dialog);
                }
            }
        }
        return ret;
    }


}
