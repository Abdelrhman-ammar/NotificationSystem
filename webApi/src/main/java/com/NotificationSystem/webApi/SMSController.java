package com.NotificationSystem.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SMSController implements Controller{

    @Autowired
    private SMSRepository repositoryObj;

    @Override
    @GetMapping("/sms")
    public SendInfo get(@RequestParam int id) {
        return repositoryObj.findById(id).orElseThrow(null);
    }

    @Override
    @PostMapping("/sms")
    public int create(@RequestBody SendInfo obj) {
        repositoryObj.save((SMS)obj);
        return 0;
    }

    @Override
    @PutMapping("/sms")
    public boolean update(@RequestBody SendInfo newObj) {
        repositoryObj.save((SMS)newObj);
        return false;
    }

    @Override
    @DeleteMapping("/sms")
    public boolean delete(@RequestParam int id) {
        repositoryObj.deleteById(id);
        return false;
    }

    @Override
    @GetMapping("/sendSms")
    public boolean send(@RequestParam int id) {
        SMS obj = repositoryObj.getOne(id);
        obj.setSendSuccessfully(true);
        update(obj);
        return false;
    }

    @GetMapping("/getAllSms")
    public List<SMS> getAll() {
        return repositoryObj.findAll();
    }


    @GetMapping("/getSmsPhoCon")
    public int _getByPhoneNumAndNotificationId(@RequestParam String phoneNum,@RequestParam int notificationId){
        //return repositoryObj.getByPhoneNumAndNotificationId(phoneNum, notificationId);
        return repositoryObj.findByNotificationIdAndPhoneNumber(notificationId, phoneNum);
    }



}
