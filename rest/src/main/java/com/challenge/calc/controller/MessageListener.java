package com.challenge.calc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class MessageListener {

    @RabbitListener(queues = "messages")
    public void listener(@RequestParam String message) throws JsonProcessingException {
        /*ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(message);

        String operator = jsonNode.get("operator").asText();
        String a = jsonNode.get("a").asText();
        String b = jsonNode.get("b").asText();

        System.out.println(operator+a+b+"Feito");*/


    }
}
