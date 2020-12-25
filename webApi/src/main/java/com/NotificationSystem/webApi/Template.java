package com.NotificationSystem.webApi;

import javax.persistence.*;

@MappedSuperclass
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String header;
    protected String content;
    protected Language lang;

    public Template(String header, String content, Language lang, int id) {
        this.header = header;
        this.content = content;
        this.lang = lang;
        this.id = id;
    }

    public Template() {

    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
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

    public void setContent(String content) {
        this.content = content;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public void setId(int id) {
        this.id = id;
    }
}
