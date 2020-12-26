package com.NotificationSystem.webApi;

public interface BController {
    Template get(int id);
    String update(Template newObj);
    String delete(int id);
}
