package com.sample.cloud.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = { CloudStreamSink.class, CloudStreamSource.class})
public class CloudStreamPublisher {

}
