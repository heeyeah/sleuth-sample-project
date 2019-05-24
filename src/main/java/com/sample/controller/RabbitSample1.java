package com.sample.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class RabbitSample1 {

	private static final Logger logger = LoggerFactory.getLogger(RabbitSample1.class);
	
	@RabbitListener(queues = "sample1")
	public void onMessage(Message message) {
		logger.info("======== {}", LocalDateTime.now());
	}
	
	@Bean Queue queue() {
		return new Queue("sample1", false);
	}
	
	
	
}
