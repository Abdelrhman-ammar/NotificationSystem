package com.NotificationSystem.webApi;

import javax.persistence.*;

@Entity
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
