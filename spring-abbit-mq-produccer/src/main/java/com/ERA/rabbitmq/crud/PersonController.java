package com.ERA.rabbitmq.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @PostMapping("/person")
    public void createTutorial(@RequestBody PersonModel personModel) {
        System.out.println("added");
        personRepository.save(personModel);

    }
}
