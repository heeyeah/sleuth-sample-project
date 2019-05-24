package com.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.util.LoggingUtil;

@CrossOrigin
@RestController
@RequestMapping("/module")
public class Module {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	
	@GetMapping("/{name}/desc")
	public String printPojoComponentDesc(@PathVariable String name) throws Exception {
		
		LoggingUtil.logHeadersInfo(request);
		
		return String.format("[module-1] [%s] printPojoComponentDesc", name);
	}
	
	@GetMapping("/{name}/version")
	public String printPojoComponentVersion(@PathVariable String name) throws Exception {
		
		LoggingUtil.logHeadersInfo(request);
		
		return String.format("[module-2] [%s] printPojoComponentVersion", name);
	}
	
	@GetMapping("/{param}")
	public String consumeMsg(@PathVariable String param) {
		
		Object msg = rabbitTemplate.receiveAndConvert(param);
		
		return (String) msg;
	}
}
