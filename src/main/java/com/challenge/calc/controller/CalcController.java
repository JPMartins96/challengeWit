package com.challenge.calc.controller;

import com.challenge.calc.config.RabbitmqConfig;
import com.challenge.calc.model.Request;
import com.challenge.calc.model.Result;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CalcController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("/add")
    public Result add(@RequestParam(name = "a", required = true) String a, @RequestParam(name = "b", required = true) String b) {
        try {
            Request request = new Request(a, b);

            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, RabbitmqConfig.ROUTING_KEY, mapper.writeValueAsString(request));

            String result = (String) rabbitTemplate.receiveAndConvert(RabbitmqConfig.QUEUE_NAME);

            System.out.println(result);

            return new Result(new BigDecimal(1));
        }catch (Exception e) {
            return new Result(new BigDecimal(-1));
        }
    }
}
