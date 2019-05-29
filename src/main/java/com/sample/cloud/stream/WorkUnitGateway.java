package com.sample.cloud.stream;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface WorkUnitGateway {

	@Gateway(requestChannel=CloudStreamSource.CHANNEL_NAME)
	void generate(WorkUnit workUnit);
}
