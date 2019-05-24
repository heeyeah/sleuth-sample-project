package com.sample.food;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface FoodOrderSource {

	@Output("foodOrdersChannel") // ?? what is this
	MessageChannel foodOrders();
}
