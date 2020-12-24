package com.NotificationAPI.Notification_System;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Notification extends Blueprint {

    public Notification() {
        super();
    }

    public Notification(String header, String content, String language,valuesWithArgs args) {
        super(header, content, language);
        for (int i = 0; i < args.getSize(); i++) {
            this.content = content.replaceFirst("\\$", args.getArgs(i));
        }
    }

    @Override
    public String toString() {
        return "Notification " + id + "\n" + header + "\n" + content + "\n" + language + '\n';
    }
}
