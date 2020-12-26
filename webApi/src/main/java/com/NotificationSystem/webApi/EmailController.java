package com.NotificationSystem.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmailController implements Controller{
    @Autowired
    private EmailRepository repositoryObj;

    @Override
    @GetMapping("/Email")
    public SendInfo get(@RequestParam int id) {
        return repositoryObj.findById(id).orElseThrow(null);
    }

    @Override
    @PostMapping("/Email")
    public int create(@RequestBody SendInfo obj) {
        repositoryObj.save((Email)obj);
        return 1;
    }

    @Override
    @PutMapping("/Email")
    public boolean update(@RequestBody SendInfo newObj) {
        repositoryObj.save((Email)newObj);
        return false;
    }

    @Override
    @DeleteMapping("/Email")
    public boolean delete(@RequestParam int id) {
        repositoryObj.deleteById(id);
        return false;
    }

    @Override
    @GetMapping("/sendEmail")
    public boolean send(@RequestParam int id) {
        Email obj = repositoryObj.getOne(id);
        obj.setSendSuccessfully(true);
        update(obj);
        return false;
    }

    @GetMapping("/getAllEmails")
    public List<Email> getAll() {
        return repositoryObj.findAll();
    }
}
