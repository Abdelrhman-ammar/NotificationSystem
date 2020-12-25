package com.NotificationSystem.webApi;

import org.springframework.web.bind.annotation.*;

@RestController
public class TemplateController implements BController {
    private TemplateRepository templateRepository;

    @Override
    @GetMapping("/Template")
    public Template get(@RequestParam int id) {

        return (Template) templateRepository.findAll();
    }

    @GetMapping("/")
    public String getAll(){return "done";}


    @GetMapping("/t")
    public int create() {
        Template obj = new Template("hello" , "email" , Language.En);
        templateRepository.save(obj);
        return 0;
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
