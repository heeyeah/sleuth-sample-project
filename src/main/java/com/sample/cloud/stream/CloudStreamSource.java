package com.sample.cloud.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Producer
 * @author Hee
 *
 */
public interface CloudStreamSource {

	String CHANNEL_NAME = "cloudStreamChannel";
	
	@Output(CHANNEL_NAME)
	MessageChannel worksChannel();
}
