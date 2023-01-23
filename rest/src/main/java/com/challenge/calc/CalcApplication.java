package com.challenge.calc;

import com.challenge.calc.controller.CalcController;
import com.challenge.calc.controller.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public class CalcApplication {

	private final static String QUEUE_NAME = RabbitmqConfig.QUEUE_NAME;

	public static void main(String[] argv) throws Exception {
		RabbitTemplate rabbitTemplate = new RabbitTemplate();
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
			System.out.println(" [x] Received '" + message + "'");
			String resultado = "0";

			String arrMessage[] = message.split(",");

			BigDecimal a = new BigDecimal(arrMessage[1]);
			BigDecimal b = new BigDecimal(arrMessage[2]);


			switch (arrMessage[0]){
				case "add":
					resultado = CalcController.add(a,b);
					break;
				case "sub":
					resultado = CalcController.sub(a,b);
					break;
				case "multiply":
					resultado = CalcController.multiply(a,b);
					break;
				case "divide":
					resultado = CalcController.divide(a,b);
					break;
				default:
					resultado = "Erro";
			}
			System.out.println("Resultado: "+resultado);
		};
		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
	}
}
