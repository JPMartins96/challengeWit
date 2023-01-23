package com.challenge.calc.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
public class CalcController {

    @Autowired
    private static RabbitTemplate rabbitTemplate;

    public static String add(BigDecimal a, BigDecimal b){
        try {
            final BigDecimal result = a.add(b);

            String resultstr = result.toString();

            return resultstr;
        }catch (Exception e){
            String erro = e.getMessage();
            return erro;
        }
    }

    public static String sub(BigDecimal a, BigDecimal b){
        try {
            final BigDecimal result = a.subtract(b);

            String resultstr = result.toString();

            return resultstr;
        }catch (Exception e){
            String erro = e.getMessage();
            return erro;
        }
    }

    public static String multiply(BigDecimal a, BigDecimal b){
        try {
            final BigDecimal result = a.multiply(b);

            String resultstr = result.toString();

            return resultstr;
        }catch (Exception e){
            String erro = e.getMessage();
            return erro;
        }
    }

    public static String divide(BigDecimal a, BigDecimal b){
        try {
            final BigDecimal result = a.divide(b);

            String resultstr = result.toString();

            return resultstr;
        }catch (Exception e){
            String erro = e.getMessage();
            return erro;
        }
    }
}
