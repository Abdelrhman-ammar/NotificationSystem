package com.NotificationSystem.webApi;

public interface BController {
    Template get(int id);
    boolean update(int id, Template newObj);
    boolean delete(int id);
}
