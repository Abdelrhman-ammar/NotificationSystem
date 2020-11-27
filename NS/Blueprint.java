package Not_Sys;

import javax.persistence.*;
import java.util.ArrayList;

@MappedSuperclass
public abstract class Blueprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;
    @Column(name = "header")
    protected String header;
    @Column(name = "content")
    protected String content;
    @Column(name = "language")
    protected String language;

    Blueprint() {
    }

    Blueprint(String header, String content, String language) {
        this.header = header;
        this.content = content;
        this.language = language;
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
