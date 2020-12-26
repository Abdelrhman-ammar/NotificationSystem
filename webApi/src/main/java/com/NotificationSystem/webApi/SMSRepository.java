package com.NotificationSystem.webApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSRepository extends JpaRepository<SMS, Integer> {
    //SMS getByPhoneNumAndNotificationId(String phoneNum, int notificationId);

    @Query("select id from sms s WHERE s.notification_id = :notificationId AND s.phone_num = :phone_num")
    int findByNotificationIdAndPhoneNumber(@Param("notification_id") int notification_id, @Param("phone_num") String phone_num);
}
