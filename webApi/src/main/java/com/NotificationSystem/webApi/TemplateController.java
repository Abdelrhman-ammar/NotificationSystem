package com.NotificationSystem.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemplateController implements BController {
    @Autowired
    private TemplateRepository templateRepository;

    @Override
    @GetMapping("/Template")
    public Template get(@RequestParam int id) {

        return templateRepository.findById(id).orElse(null);
    }


    @Override
    public boolean update(int id, Template newObj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
