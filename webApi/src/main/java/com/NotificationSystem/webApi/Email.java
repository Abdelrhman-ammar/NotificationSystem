package com.NotificationSystem.webApi;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Entity;

@Entity
@JsonDeserialize(as = Email.class)
public class Email extends SendInfo{
    private String email;

    public Email(int notificationId, String email, boolean sendSuccessfully){
        super(notificationId, sendSuccessfully);
        this.email = email;
    }

    public Email(){
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
