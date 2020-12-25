package com.NotificationSystem.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;
    @PostMapping("/Notification")
    public Notification create(@RequestBody Template t, @PathVariable ArrayList<String> args ) {
        Notification newNotification=new Notification(t,args);
        notificationRepository.save(newNotification);
        return newNotification;
    }

    @GetMapping("/Notification/{id}")
    public Notification read(@PathVariable int id ) {
        return notificationRepository.findById(id);
    }

    @PutMapping("/Notification/{id}")
    public boolean update(@RequestBody Notification n,@PathVariable int id) {
        Notification existingNotification = notificationRepository.findById(id);
        existingNotification.setHeader(n.getHeader());
        existingNotification.setContent(n.getContent());
        existingNotification.setLang(n.getLang());
        return true;
    }

    @DeleteMapping("/Notification/{id}")
    public boolean delete(@PathVariable int id ) {
        notificationRepository.deleteById(id);
        return true;
    }
}
