package com.NotificationSystem.webApi;

public interface Controller {
    SendInfo get(int id);
    int create(SendInfo obj);
    boolean update(int id, SendInfo newObj);
    boolean delete(int id);
}
