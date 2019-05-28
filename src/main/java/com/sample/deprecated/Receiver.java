package com.sample.deprecated;
//package com.sample.rabbitmq;
//
//import java.util.concurrent.CountDownLatch;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * With any messaging-based application, you need to create a receiver that will respond to published messages.
// */
//@Component
//public class Receiver {
//	
//	private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
//    private CountDownLatch latch = new CountDownLatch(1);
//
//    public void receiveMessage(String message) {
//    	logger.info("Received <{}>", message);
//        latch.countDown();
//    }
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//
//}
