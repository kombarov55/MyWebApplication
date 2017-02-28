package com.vk.kombarov_nikolay.model.dao;

import com.vk.kombarov_nikolay.config.RootConfig;
import com.vk.kombarov_nikolay.model.database.Dao;
import com.vk.kombarov_nikolay.model.database.IMessageDao;
import com.vk.kombarov_nikolay.model.messenger.Dialog;
import com.vk.kombarov_nikolay.model.messenger.Message;
import com.vk.kombarov_nikolay.model.messenger.util.TableNameCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by nikolaykombarov on 26.01.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class DialogDaoTest {

    @Autowired
    @Qualifier("DialogDao")
    private  Dao<Dialog> dialogDao;

    @Autowired
    private IMessageDao messageDao;

    @Test
    public void test() throws Exception {
        Dialog dialog = new Dialog();
        dialog.setUsername1("Gaben");
        dialog.setUsername2("Mooly");
        dialog.setTableName(TableNameCreator.createTableName(dialog.getUsername1(), dialog.getUsername2()));
        dialogDao.add(dialog);
        Set<Message> messageSet = messageDao.getAllMessages(dialog.getTableName());
        dialogDao.remove(dialog.getTableName());
    }
}
