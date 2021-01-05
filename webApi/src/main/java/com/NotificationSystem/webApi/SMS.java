package com.NotificationSystem.webApi;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

@Entity
@JsonDeserialize(as = SMS.class)
public class SMS extends SendInfo{

    private String phoneNum;

    public SMS(int notificationId, String phoneNum, boolean sendSuccessfully){
        super(notificationId, sendSuccessfully);
        this.phoneNum = phoneNum;
    }

    public SMS(){
        super();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}
