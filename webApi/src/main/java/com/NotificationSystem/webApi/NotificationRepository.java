package com.NotificationSystem.webApi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {

    Notification findById(int id);
    Notification deleteById(int id);

}
