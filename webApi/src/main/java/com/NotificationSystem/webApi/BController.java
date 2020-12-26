package com.NotificationSystem.webApi;

public interface BController {
    Template get(int id);
    boolean update(Template newObj);
    boolean delete(int id);
}
