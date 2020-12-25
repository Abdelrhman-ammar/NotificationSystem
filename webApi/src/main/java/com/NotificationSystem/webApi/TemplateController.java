package com.NotificationSystem.webApi;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class TemplateController implements BController {
    private TemplateRepository templateRepository;

    @Override
    @GetMapping("/Template/{id}")
    public Template get(@PathVariable int id) {
        return templateRepository.findById(id).orElse(null);
    }


    @PostMapping("/Template")
    public int create(Template obj) {
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
