package com.NotificationSystem.webApi;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Notification extends Template {

    public Notification() {
    }

    public Notification(Template t, ArrayList<String> args)
    {
        this.header=t.header;
        this.lang=t.lang;
        for (int i = 0; i < args.size(); i++) {
            this.content = content.replaceFirst("\\$", args.get(i));
        }
    }

    @Override
    public String toString() {
        return "Notification " + id + "\n" + header + "\n" + content + "\n" + lang + '\n';
    }
}
