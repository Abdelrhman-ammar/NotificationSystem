package com.NotificationSystem.webApi;

public interface BController {
    String get(int id);
    String update(Template newObj);
    String delete(int id);
}
