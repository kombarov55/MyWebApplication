package com.vk.kombarov_nikolay.model.messenger;

import com.vk.kombarov_nikolay.model.database.Dao;
import com.vk.kombarov_nikolay.model.database.IMessageDao;
import com.vk.kombarov_nikolay.model.messenger.util.TableNameCreator;
import com.vk.kombarov_nikolay.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nikolaykombarov on 04.01.17.
 */
@Component
public class MessengerServiceImpl implements MessengerService {

    @Qualifier("DialogDao")
    private Dao<Dialog> dialogDao;
    private IMessageDao messageDao;

    @Autowired
    public MessengerServiceImpl(Dao dialogDao, IMessageDao messageDao) {
        this.dialogDao = dialogDao;
        this.messageDao = messageDao;
    }

    @Override
    public Dialog getDialog(String tableName) throws SQLException {
        return dialogDao.get(tableName);
    }

    @Override
    public List<Dialog> lookupDialogs(String username) throws SQLException {
        List<Dialog> ret = new ArrayList<>();
        Map<String, String> params = new HashMap<>();

        params.put("username1", username);
        ret.addAll(dialogDao.lookup(params));
        params.remove("username1");

        params.put("username2", username);
        ret.addAll(dialogDao.lookup(params));

        return ret;
    }

    @Override
    public void sendMessage(User sender, String tableName, String content) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        Message message = new Message(sqlDate, content, sender.getUsername());

        messageDao.add(tableName, message);
    }

    @Override
    public Dialog createDialog(String username1, String username2) throws SQLException {
        Dialog dialog = new Dialog(username1, username2,
                TableNameCreator.createTableName(username1, username2));

        dialogDao.add(dialog);
        return dialog;
    }
}
