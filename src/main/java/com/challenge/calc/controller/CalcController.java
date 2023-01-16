package com.challenge.calc.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.math.BigDecimal;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CalcController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("/add")
    public String add(@RequestParam BigDecimal a, @RequestParam BigDecimal b) throws IOException{
        try {
            final BigDecimal result = a.add(b);

            String resultstr = result.toString();

            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, RabbitmqConfig.ROUTING_KEY, mapper.writeValueAsString(resultstr));

            resultstr = (String) rabbitTemplate.receiveAndConvert(RabbitmqConfig.QUEUE_NAME);

            return resultstr;
        }catch (Exception e){
            return "Erro de calculo";
        }
    }
    @GetMapping("/sub")
    public String sub(@RequestParam BigDecimal a, BigDecimal b){
        try {
            final BigDecimal result = a.subtract(b);

            String resultstr = result.toString();

            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, RabbitmqConfig.ROUTING_KEY, mapper.writeValueAsString(resultstr));

            resultstr = (String) rabbitTemplate.receiveAndConvert(RabbitmqConfig.QUEUE_NAME);

            return resultstr;
        }catch (Exception e){
            return "Erro de calculo";
        }
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        try {
            final BigDecimal result = a.multiply(b);

            String resultstr = result.toString();

            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, RabbitmqConfig.ROUTING_KEY, mapper.writeValueAsString(resultstr));

            resultstr = (String) rabbitTemplate.receiveAndConvert(RabbitmqConfig.QUEUE_NAME);

            return resultstr;
        }catch (Exception e){
            return "Erro de calculo";
        }
    }

    @GetMapping("/divide")
    public String divide(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        try {
            final BigDecimal result = a.divide(b);

            String resultstr = result.toString();

            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, RabbitmqConfig.ROUTING_KEY, mapper.writeValueAsString(resultstr));

            resultstr = (String) rabbitTemplate.receiveAndConvert(RabbitmqConfig.QUEUE_NAME);

            return resultstr;
        }catch (Exception e){
            return "Erro de calculo";
        }
    }
}
