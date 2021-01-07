package com.NotificationSystem.webApi;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    private NotificationRepository notificationRepo;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration, NotificationRepository nRepo) {
        this.twilioConfiguration = twilioConfiguration;
        this.notificationRepo = nRepo;
    }

    @Override
    public void sendSms(SMS smsRequest) {
        Notification notification = notificationRepo.findById(smsRequest.getNotificationId());
        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNum());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String message = notification.getContent();
        MessageCreator creator = Message.creator(to, from, message);
        creator.create();
        notification.setSent();
        notificationRepo.save(notification);
        LOGGER.info("Send sms {}", smsRequest);

    }

}
