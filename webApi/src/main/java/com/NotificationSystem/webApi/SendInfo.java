package com.NotificationSystem.webApi;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@JsonDeserialize(using = InstanceDeserializer.class)
public abstract class SendInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected int notificationId;
    protected boolean sendSuccessfully;

    public SendInfo(int notificationId, boolean sendSuccessfully) {
        this.notificationId = notificationId;
        this.sendSuccessfully = sendSuccessfully;
    }

    public SendInfo(){
    }

    public int getId() {
        return id;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public boolean isSendSuccessfully() {
        return sendSuccessfully;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public void setSendSuccessfully(boolean sendSuccessfully) {
        this.sendSuccessfully = sendSuccessfully;
    }
}
