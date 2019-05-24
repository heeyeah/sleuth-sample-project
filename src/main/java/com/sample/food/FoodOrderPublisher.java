package com.sample.food;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(FoodOrderSource.class)
public class FoodOrderPublisher {

	/*
	 * With all that ready, we can define a simple controller that will make use of these classes and publish the message upon receiving the FoodOrder
	 */
}
