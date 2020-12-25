package com.NotificationSystem.webApi;

public interface BController {
    Template get(int id);
    int create(Template obj);
    boolean update(int id, Template newObj);
    boolean delete(int id);
}
