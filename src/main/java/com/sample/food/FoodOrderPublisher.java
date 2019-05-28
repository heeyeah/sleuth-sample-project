package com.sample.food;

import org.springframework.cloud.stream.annotation.EnableBinding;

//Enables the binding of targets annotated with Input and Output to a broker, according to the list of interfaces passed as value to the annotation.
@EnableBinding(FoodOrderSource.class)
public class FoodOrderPublisher {
	/*
	 * With all that ready, we can define a simple controller that will make use of
	 * these classes and publish the message upon receiving the FoodOrder
	 */
}
