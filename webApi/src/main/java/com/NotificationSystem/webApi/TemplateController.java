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
    public String update(@RequestBody Template newObj) {
        Template tempObj = templateRepository.findById(newObj.id).orElse(null);
        tempObj.setHeader(newObj.getHeader());
        tempObj.setContent(newObj.getContent());
        tempObj.setLang(newObj.getLang());
        templateRepository.save((Template) tempObj);
        return "Template updated Successfully";
    }

    @Override
    @DeleteMapping("/Template")
    public String delete(@RequestParam int id) {
        templateRepository.deleteById(id);
        return "Template With id = " + id + " deleted Successfully";
    }

    @PostMapping("/Template")
    public String create(@RequestBody Template obj) {
        templateRepository.save((Template) obj);
        return String.valueOf(obj.getId());
    }

    @GetMapping("/Template/all")
    public List<Template> getAll()
    {
        return templateRepository.findAll();
    }

}
