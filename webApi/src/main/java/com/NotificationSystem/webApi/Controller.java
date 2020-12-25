package com.NotificationSystem.webApi;

import java.util.List;

public interface Controller {
    SendInfo get(int id);
    int create(SendInfo obj);
    boolean update(SendInfo newObj);
    boolean delete(int id);
    boolean send(int id);
}
