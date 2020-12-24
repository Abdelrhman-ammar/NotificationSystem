package com.NotificationAPI.Notification_System;


import javax.persistence.*;

@MappedSuperclass
class Blueprint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String header;
    public String content;
    public String language;


    Blueprint(String header, String content, String language) {
        this.header = header;
        this.content = content;
        this.language = language;
    }

    public Blueprint() {

    }


    public int getId() {
        return id;
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


    public String getLanguage() {
        return language;
    }


    public void setLanguage(String language) {
        this.language = language;
    }
}



