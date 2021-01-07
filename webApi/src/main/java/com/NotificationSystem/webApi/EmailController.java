package com.NotificationSystem.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class EmailController implements Controller {
    @Autowired
    private EmailRepository repositoryObj;

    @Autowired
    JavaMailSender sender;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    @GetMapping("/Email")
    public SendInfo get(@RequestParam int id) {
        return repositoryObj.findById(id).orElseThrow(null);
    }

    @Override
    @PostMapping("/Email")
    public String create(@RequestBody SendInfo obj) {
        repositoryObj.save((Email)obj);
        return "Email created Successfully";
    }

    @Override
    @PutMapping("/Email")
    public String update(@RequestBody SendInfo newObj) {
        repositoryObj.save((Email)newObj);
        return "Email updated Successfully";
    }

    @Override
    @DeleteMapping("/Email")
    public String delete(@RequestParam int id) {
        repositoryObj.deleteById(id);
        return "Email deleted Successfully";
    }

    @Override
    @GetMapping("/Email/send")
    public String send(@RequestParam int id) {
        Email toBeSent = repositoryObj.getOne(id);
        Notification n = notificationRepository.findById(toBeSent.getNotificationId());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("notificationsysapi@gmail.com");
        message.setTo(toBeSent.getEmail());
        message.setSubject(n.getHeader());
        message.setText(n.getContent());
        sender.send(message);
        n.setSent();
        notificationRepository.save(n);
        repositoryObj.deleteById(id);
        return "Email With id = " + id + " send Successfully";
    }

    @GetMapping("/Email/send/all")
    public String sendAll() throws InterruptedException {
        ArrayList<Email> emailsToBeSent;
        emailsToBeSent = (ArrayList<Email>) repositoryObj.findAll();
        for(int i=0; i<emailsToBeSent.size(); i++)
        {
                wait(500);
                Email toBeSent = emailsToBeSent.get(i);
                Notification n = notificationRepository.findById(toBeSent.getNotificationId());
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("notificationsysapi@gmail.com");
                message.setTo(toBeSent.getEmail());
                message.setSubject(n.getHeader());
                message.setText(n.getContent());
                sender.send(message);
                n.setSent();
                notificationRepository.save(n);
                repositoryObj.deleteById(toBeSent.getId());
        }
        return "Emails were sent successfully";
    }

    @GetMapping("/Email/all")
    public List<Email> getAll() {
        return repositoryObj.findAll();
    }
}
