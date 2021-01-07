package com.NotificationSystem.webApi;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.ArrayList;

@Entity
public class Notification extends Template {

    protected boolean sent=false;

    public void setSent() {
        this.sent = true;
    }

    public Notification() {
    }

    public Notification(Template t, ArrayList<String> args)
    {
        this.header=t.header;
        this.lang=t.lang;
        this.content=t.content;
        for (int i = 0; i < args.size(); i++) {
            this.content = content.replaceFirst("\\$", args.get(i));
        }
    }

    @Override
    public String toString() {
        return "Notification " + id + "\n" + header + "\n" + content + "\n" + lang + '\n';
    }
}
