package com.NotificationSystem.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String create(@RequestBody SendInfo obj) {
        repositoryObj.save((SMS)obj);
        return "SMS created Successfully";
    }

    @Override
    @PutMapping("/sms")
    public String update(@RequestBody SendInfo newObj) {
        repositoryObj.save((SMS)newObj);
        return "SMS updated Successfully";
    }

    @Override
    @DeleteMapping("/sms")
    public String delete(@RequestParam int id) {
        repositoryObj.deleteById(id);
        return "SMS With id = " + id + "deleted Successfully";
    }

    @Override
    @GetMapping("/sms/send")
    public String send(@RequestParam int id) {
        SMS obj = repositoryObj.getOne(id);
        obj.setSendSuccessfully(true);
        update(obj);
        return "SMS With id = " + id + "send Successfully";
    }

    @GetMapping("/sms/all")
    public List<SMS> getAll() {
        return repositoryObj.findAll();
    }

/*
    @GetMapping("/getSmsPhoCon")
    public Integer _getByNotificationIdAndPhoneNum(@RequestParam int notificationId, @RequestParam String phoneNum){
        //return repositoryObj.findByPhoneNumAndNotificationId(phoneNum, notificationId);
        //return repositoryObj.findById(1);
        return repositoryObj.fun(notificationId, phoneNum);
    }*/



}
