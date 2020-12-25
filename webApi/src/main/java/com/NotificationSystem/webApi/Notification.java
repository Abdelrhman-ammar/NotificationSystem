package com.NotificationSystem.webApi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {
    private String header;
    private String conent;
    private Language lang;
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    public Notification(String header, String conent, Language lang, int id) {
        this.header = header;
        this.conent = conent;
        this.lang = lang;
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public String getConent() {
        return conent;
    }

    public Language getLang() {
        return lang;
    }

    public int getId() {
        return id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setConent(String conent) {
        this.conent = conent;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public void setId(int id) {
        this.id = id;
    }
}
