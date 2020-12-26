package com.NotificationSystem.webApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class NotificationController implements BController {

    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping("/Notification")
    public Notification create(@RequestParam int id) throws IOException {


        URL url = new URL("http://localhost:8080/Template?id=" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        Map<String, Integer> parameters = new HashMap<>();
        parameters.put("id", id);
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json");
        String contentType = con.getHeaderField("Content-Type");
        con.connect();


        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();
        System.out.println("content = " + content);
/*
        String url = "localhost:8080/Template?id=" + id;
        Template templateObj =  this.restTemplate.getForObject(url, String.class);
*/


        //Notification newNotification = new Notification(id, args);
        //notificationRepository.save(newNotification);
        //return newNotification;
        return null;
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
