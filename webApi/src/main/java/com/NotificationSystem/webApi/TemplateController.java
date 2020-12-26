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
    @PutMapping("/Template")
    public boolean update(@RequestBody Template newObj) {
        Template tempObj = templateRepository.findById(newObj.id).orElse(null);
        tempObj.setHeader(newObj.getHeader());
        tempObj.setContent(newObj.getContent());
        tempObj.setLang(newObj.getLang());
        templateRepository.save((Template) tempObj);
        return false;
    }

    @Override
    @DeleteMapping("/Template")
    public boolean delete(int id) {
        templateRepository.deleteById(id);
        return false;
    }

    @PostMapping("/Template")
    public int create(@RequestBody Template obj) {
        templateRepository.save((Template) obj);
        return 0;
    }

}
