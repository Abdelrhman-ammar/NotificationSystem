package com.NotificationAPI.Notification_System;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SMS {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;
    private String header;
    private String content;
    private String phoneNumber;
    private boolean sendSuccessfully;

    public SMS(String id, String header, String content, String phoneNumber, boolean sendSuccessfully) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.phoneNumber = phoneNumber;
        this.sendSuccessfully = sendSuccessfully;
    }

    public SMS(){
        this.header = "";
        this.content = "";
        this.phoneNumber = "";
        this.sendSuccessfully = false;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isSendSuccessfully() {
        return sendSuccessfully;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSendSuccessfully(boolean sendSuccessfully) {
        this.sendSuccessfully = sendSuccessfully;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
