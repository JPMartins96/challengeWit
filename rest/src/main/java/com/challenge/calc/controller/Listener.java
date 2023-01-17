package com.challenge.calc.controller;
/*
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class Listener {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "messages")
    public String listener(@RequestParam String message) throws JsonProcessingException {
        System.out.println(message);

        ObjectMapper mapper = new ObjectMapper();

        Response response = mapper.readValue(message, Response.class);


    }
}
*/