package com.NotificationSystem.webApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SMSRepository extends JpaRepository<SMS, Integer> {
    //Optional<SMS> findByPhoneNumAndNotificationId(String phoneNum, Integer notificationId);
/*
    @Query("select id from sms s WHERE s.notification_id = ?1 AND s.phone_num = ?2")
    int fun(@Param("notification_id") Integer notification_id,@Param("phone_num") String phone_num);*/
}
