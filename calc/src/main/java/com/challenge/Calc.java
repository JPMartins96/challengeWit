package com.challenge;

import com.challenge.controller.RabbitmqConfig;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Calc {
    @Bean
    Queue queue() {
        return new Queue(RabbitmqConfig.QUEUE_NAME, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(RabbitmqConfig.EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitmqConfig.ROUTING_KEY);
    }

    @Bean
    Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    public static void main(String[] args) {
        SpringApplication.run(Calc.class, args);
    }

}
