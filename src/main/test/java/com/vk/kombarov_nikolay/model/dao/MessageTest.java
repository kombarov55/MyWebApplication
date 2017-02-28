package com.vk.kombarov_nikolay.model.dao;

import com.vk.kombarov_nikolay.config.RootConfig;
import com.vk.kombarov_nikolay.model.database.MessageDao;
import com.vk.kombarov_nikolay.model.messenger.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * Created by nikolaykombarov on 15.02.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class MessageTest {

    @Autowired
    private MessageDao messageDao;

    @Test
    public void test() throws Throwable {
        Set<Message> messages = messageDao.getAllMessages("gaben_gabe");
        System.out.println(messages);
    }

}
