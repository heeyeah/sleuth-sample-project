package com.sample.cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Consumer
 * handle the incoming message from RabbitMQ
 * @author Hee
 *
 */
public interface CloudStreamSink {

	String CHANNEL_NAME = "cloudStreamChannelSink";
	
	@Input(CHANNEL_NAME)
	SubscribableChannel subscribableChannel();
}
