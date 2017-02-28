package com.vk.kombarov_nikolay.model.messenger;

import java.sql.Date;

/**
 * Created by nikolaykombarov on 04.01.17.
 */
public class Message {

    private Date date;
    private String content;
    private String sender;

    public Message() {
    }

    public Message(Date date, String content, String sender) {
        this.date = date;
        this.content = content;
        this.sender = sender;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "date=" + date +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
