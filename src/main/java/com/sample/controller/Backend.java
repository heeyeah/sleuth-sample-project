package com.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.util.LoggingUtil;

@CrossOrigin
@RestController
@RequestMapping("/back")
public class Backend {

	@Value("${sample.callUrl.module}")
	private String callUrl;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/{name}")
	public String justReturnString(@PathVariable String name) throws Exception {
		
		LoggingUtil.logHeadersInfo(request);
		return String.format("[backend-1] [%s] justReturnString", name);
	}
	
	@GetMapping(value="/module/{name}/{type}")
	public String callModule(@PathVariable String name, @PathVariable String type) throws Exception {
		
		LoggingUtil.logHeadersInfo(request);
		
		String callModule = restTemplate.getForObject(String.format("%s/module/%s/%s", callUrl, name, type), String.class);
		return "[backend-2] callModule \n" + callModule;
	}
	
}
