package com.challenge.controller;

import com.challenge.Calc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @GetMapping("/publish")
    public String publishMessage(@RequestParam String operator, @RequestParam String a, @RequestParam String b){

        String message = new CustomMessage().composeMessage(operator, a, b);

        template.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, RabbitmqConfig.ROUTING_KEY, message);

        System.out.println("Mensagem Enviada");

        return "Mensagem enviada";
    }
}
