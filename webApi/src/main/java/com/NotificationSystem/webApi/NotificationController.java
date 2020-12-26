package com.NotificationSystem.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class NotificationController implements BController {

    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping("/Notification")
    public Notification create(@RequestBody Template t, @PathVariable ArrayList<String> args) {
        Notification newNotification = new Notification(t, args);
        notificationRepository.save(newNotification);
        return newNotification;
    }

    @GetMapping("/Notification/{id}")
    public Notification get(@PathVariable int id) {
        return notificationRepository.findById(id);
    }


    @PutMapping("/Notification/{id}")
    public boolean update(@RequestBody Template n) {
        Notification existingNotification = notificationRepository.findById(n.getId());
        existingNotification.setHeader(n.getHeader());
        existingNotification.setContent(n.getContent());
        existingNotification.setLang(n.getLang());
        notificationRepository.save(existingNotification);
        return true;
    }

    @DeleteMapping("/Notification/{id}")
    public boolean delete(@PathVariable int id) {
        notificationRepository.deleteById(id);
        return true;
    }
}
