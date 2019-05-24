//package com.sample.rabbitmq;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * rabbitListner에 정의되어 있는 queue를 감시하다가 메시지가 들어오면 handler로 전해줌
// * @author Hee
// *
// */
//@Component
//public class Consumer {
//
//	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
//	
//	@RabbitListener(queues = "heeye-queue")
//	public void handler(String message) {
//		logger.info("consumer ...> {}", message);
//	}
//}
