package com.challenge.calc;

import com.challenge.calc.config.RabbitmqConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalcApplication {
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

	public static void main(String[] args) {
		SpringApplication.run(CalcApplication.class, args);
	}


}
