package com.NotificationSystem.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NotificationController implements BController {

    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping("/Notification")
    public String create(@RequestParam int id, @RequestBody ArrayList<String> args) throws IOException
    {
        Template t = getTemplate(id);
        Notification newNotification = new Notification(t, args);
        notificationRepository.save(newNotification);
        return String.valueOf(newNotification.getId());
    }

    @GetMapping("/Notification")
    public Notification get(@RequestParam int id) {
        return notificationRepository.findById(id);
    }

    @GetMapping("/Notification/all")
    public List<Notification> getAll()
    {
        return notificationRepository.findAll();
    }

    @PutMapping("/Notification")
    public String update(@RequestBody Template n) {
        Notification existingNotification = notificationRepository.findById(n.getId());
        existingNotification.setHeader(n.getHeader());
        existingNotification.setContent(n.getContent());
        existingNotification.setLang(n.getLang());
        notificationRepository.save(existingNotification);
        return "Notification updated successfully";
    }

    @DeleteMapping("/Notification")
    public String delete(@RequestParam int id) {
        notificationRepository.deleteById(id);
        return "Notification was deleted";
    }

    private Template getTemplate(int id) throws IOException
    {
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
        System.out.println(status);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);

        in.close();
        con.disconnect();
        return fixFormat(String.valueOf(content));
    }

    private Template fixFormat(String content)
    {
        int num=content.lastIndexOf("\"header\":\"");
        content=content.substring(num+10,content.length());
        num=content.indexOf("\",");
        String header = content.substring(0,num);

        int num2=content.indexOf("\"header\":\"");
        content=content.substring(num+num2+14,content.length());
        num=content.indexOf("\",");
        String fullContent=content.substring(0,num);

        int num3=content.indexOf("\"lang\":");
        content=content.substring(num3+7,content.length());
        String lang=content.substring(1,content.length()-2);

        Template t = new Template(header,fullContent,Language.valueOf(lang));
        return t;
    }
}
