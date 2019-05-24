package com.sample.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import brave.Tracing;
import brave.spring.rabbit.SpringRabbitTracing;

public class RabbitConfig {

	@Bean
	public Tracing tracing() {
		return Tracing.newBuilder().localServiceName("spring-amqp-producer").build();
	}
	
	@Bean
	public SpringRabbitTracing springRabbitTracing(Tracing tracing) {
		return SpringRabbitTracing.newBuilder(tracing).writeB3SingleFormat(true).remoteServiceName("rabbitmq").build();
	}

	// producer
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, SpringRabbitTracing springRabbitTracing) {
		RabbitTemplate rabbitTemplate = springRabbitTracing.newRabbitTemplate(connectionFactory);
		return rabbitTemplate;
	}
	
	//consumer
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory, SpringRabbitTracing springRabbitTracing) {
		return springRabbitTracing.newSimpleRabbitListenerContainerFactory(connectionFactory);
	}
}
