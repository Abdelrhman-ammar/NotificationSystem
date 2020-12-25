package com.NotificationSystem.webApi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SMSRepository extends JpaRepository<SMS, Integer> {
}
