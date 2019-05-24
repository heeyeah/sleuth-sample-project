package com.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.util.LoggingUtil;

import brave.sampler.Sampler;

@CrossOrigin
@RestController
@RequestMapping("/front")
public class Frontend {

	private static int depth = 1;
	private final String callUrl = System.getProperty("sample.callUrl.backend", "http://localhost:7001");
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	
	@GetMapping(value="/{name}")
	public String arriveBackend(@PathVariable String name) throws Exception {

		LoggingUtil.logHeadersInfo(request);
		
		return restTemplate.getForObject(String.format("%s/back/%s", callUrl, name), String.class);
	}
	
	@GetMapping(value="/last/{name}")
	public String arriveModule(@PathVariable String name) throws Exception {

		LoggingUtil.logHeadersInfo(request);
		
		String type;
		if(name.length() % 2 == 0) {
			type = "desc";
		} else {
			type = "version";
		}
		
		return restTemplate.getForObject(String.format("%s/back/module/%s/%s", callUrl, name, type), String.class);
	}
	
	
}
