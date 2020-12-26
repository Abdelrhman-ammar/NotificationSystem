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
        Email obj = repositoryObj.getOne(id);
        obj.setSendSuccessfully(true);
        update(obj);
        return "Email With id = " + id + " send Successfully";
    }

    @GetMapping("/Email/all")
    public List<Email> getAll() {
        return repositoryObj.findAll();
    }
}
