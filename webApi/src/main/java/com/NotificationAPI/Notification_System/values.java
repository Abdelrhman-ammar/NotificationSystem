package com.NotificationAPI.Notification_System;

public class values {
    int id;
    String header;
    String content;

    public values(int id, String header, String content) {
        this.id = id;
        this.header = header;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
