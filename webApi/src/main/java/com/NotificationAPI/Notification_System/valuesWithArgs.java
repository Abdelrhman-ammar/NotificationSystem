package com.NotificationAPI.Notification_System;

import java.util.ArrayList;

public class valuesWithArgs extends values{

    private ArrayList<String> args = new ArrayList<>();

    public valuesWithArgs(int id, String header, String content, ArrayList<String> args) {
        super(id, header, content);
        this.args = args;
    }

    public String getArgs(int i) {
        return args.get(i);
    }
    public int getSize()
    {
        return args.size();
    }
}
