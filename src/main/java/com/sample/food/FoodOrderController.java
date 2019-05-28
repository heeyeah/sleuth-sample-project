package com.sample.food;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodOrderController {

	private static final Logger logger = LoggerFactory.getLogger(FoodOrderController.class);
	
	@Autowired
	FoodOrderSource foodOrderSource;
	
	@RequestMapping("/order")
	@ResponseBody
	public String orderFood(@RequestBody FoodOrder foodOrder) {
		
		logger.info("================================================");
		logger.info("= {}", foodOrder.toString());
		logger.info("================================================");
		
		foodOrderSource.foodOrders().send(MessageBuilder.withPayload(foodOrder).build());
		
		return foodOrder.toString();
	}
}
