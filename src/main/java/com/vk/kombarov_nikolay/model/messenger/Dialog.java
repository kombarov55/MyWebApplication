package com.vk.kombarov_nikolay.model.messenger;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by nikolaykombarov on 04.01.17.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Dialog {

    public String username1;
    public String username2;
    public String tableName;

    private Set<Message> messages = new HashSet<>();

    public Dialog() {
    }

    public Dialog(String username1, String username2, String tableName) {
        this.username1 = username1;
        this.username2 = username2;
        this.tableName = tableName;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Set<Message> getMessages() {
        return Collections.unmodifiableSet(messages);
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public String getTableName() {
        return tableName;
    }

    public String getUsername1() {
        return username1;
    }

    public String getUsername2() {
        return username2;
    }

}
