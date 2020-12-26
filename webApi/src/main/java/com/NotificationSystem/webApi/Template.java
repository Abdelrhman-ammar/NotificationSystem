package com.NotificationSystem.webApi;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String header;
    protected String content;
    @Enumerated(EnumType.STRING)
    protected Language lang;

    public Template(String header, String content, Language lang) {
        this.header = header;
        this.content = content;
        this.lang = lang;
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
