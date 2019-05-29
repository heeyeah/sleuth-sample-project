package com.sample.cloud.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.sample.food.FoodOrderSource;

@Service
public class WorkHandler {

	private static final Logger logger = LoggerFactory.getLogger(WorkHandler.class);
	
	@StreamListener(CloudStreamSink.CHANNEL_NAME)
	@SendTo(FoodOrderSource.CHANNEL_NAME)
	public WorkUnit process(WorkUnit workUnit) {
		logger.info("=== Work Handler ! ===");
		return workUnit.addDetail(" workhandler process data!");
	}
}
