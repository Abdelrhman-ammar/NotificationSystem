package com.NotificationSystem.webApi;

import java.util.List;

public interface Controller {
    SendInfo get(int id);
    String create(SendInfo obj);
    String update(SendInfo newObj);
    String delete(int id);
    String send(int id);
}
