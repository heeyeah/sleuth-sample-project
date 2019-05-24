package com.sample.controller;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.sample.util.LoggingUtil;


@EnableAutoConfiguration
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitTest.class);
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@GetMapping(value="/{param}")
	public String sendMessage(@PathVariable String param) throws Exception {
		
		LoggingUtil.logHeadersInfo(request);
		
		rabbitTemplate.convertAndSend(param, String.format("[%s] Hello world, this class is RabbitTest :D", param));
		
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	 private final static String QUEUE_NAME = "hello";

	 @Value("${spring.rabbitmq.host}")
	 private String host;
	       
	@GetMapping(value = "/tmplt/{param}")
	public String sendMessageForTmplt(@PathVariable String param) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		
		String message;
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			
			message = "Hello World!@ "  + param;
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));

			logger.info(" [x] Sent '{}' ", message);
		}

		return message;
	}

	@Bean
	public void recv() throws IOException, TimeoutException {
		
		logger.info("============================================");
		logger.info("============================================");
		logger.info("========= ========= RECV ========= =========");
		logger.info("============================================");
		logger.info("============================================");
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);

		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			
			String msg = new String(delivery.getBody(), "UTF-8");
			logger.info(" [x] consumerTag '{}'", consumerTag);
			logger.info(" [x] RoutingKey '{}' ", delivery.getEnvelope().getRoutingKey());
			logger.info(" [x] Received '{}' ", msg);
		};
		
		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
	}
}
