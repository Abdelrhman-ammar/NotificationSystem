package com.NotificationAPI.Notification_System;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;
    private String header;
    private String content;
    private String email;
    private boolean sendSuccessfully;
    public String getId() {
        return id;
    }

    public Email(String id, String header, String content, String email, boolean sendSuccessfully) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.email = email;
        this.sendSuccessfully = sendSuccessfully;
    }

    public Email() {
        this.header = "";
        this.content = "";
        this.email = "";
        this.sendSuccessfully = false;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public String getPhoneNumber() {
        return email;
    }

    public boolean isSendSuccessfully() {
        return sendSuccessfully;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPhoneNumber(String email) {
        this.email = email;
    }

    public void setSendSuccessfully(boolean sendSuccessfully) {
        this.sendSuccessfully = sendSuccessfully;
    }
}
