package com.sample.food;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface FoodOrderSource {

	String CHANNEL_NAME = "foodOrdersChannel";
	
	@Output(CHANNEL_NAME)
	MessageChannel foodOrders();
}
