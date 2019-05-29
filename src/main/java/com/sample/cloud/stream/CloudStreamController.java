package com.sample.cloud.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudStreamController {

	private static final Logger logger = LoggerFactory.getLogger(CloudStreamController.class);

	@Autowired
	CloudStreamSource cloudStreamSource;

	@Autowired
	CloudStreamSink cloudStreamSink;

	@RequestMapping("/cloud")
	@ResponseBody
	public String sendWorkUnit(@RequestBody WorkUnit workUnit) {
		
		logger.info("================================================");
		logger.info("= {}", workUnit.toString());
		logger.info("================================================");
		
		cloudStreamSource.worksChannel().send(MessageBuilder.withPayload(workUnit).build());
		
		return workUnit.toString();
	}
}
