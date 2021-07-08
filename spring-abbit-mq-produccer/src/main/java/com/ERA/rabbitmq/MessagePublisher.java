package com.ERA.rabbitmq;

import com.ERA.rabbitmq.crud.PersonModel;
import com.ERA.rabbitmq.crud.PersonRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessagePublisher {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    PersonRepository personRepository;
    @PostMapping("/publish")
//    public String publishMessage( @RequestBody CustomMessage message){
    public String publishMessage( @RequestBody PersonModel personModel){
        //PersonModel personModel = new PersonModel();
        CustomMessage message = new CustomMessage();
    //personModel.setName("Zohir bhai");
    personRepository.save(personModel);
    message.setMessage(personModel.getName());
    message.setMessageDate(new Date());
    rabbitTemplate.convertAndSend(MQ_config.EXCHANGE,MQ_config.ROUTING_KEY,message);
    return "message published";
    }
}
