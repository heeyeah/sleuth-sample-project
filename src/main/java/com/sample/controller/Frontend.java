package com.sample.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.dto.Component;
import com.sample.util.LoggingUtil;

import brave.sampler.Sampler;

@CrossOrigin
@RestController
@RequestMapping("/")
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
	public ResponseEntity<Component> getComponentInfo(@PathVariable String name) throws Exception {

		LoggingUtil.logHeadersInfo(request);
		
		Component comp = restTemplate.getForObject(String.format("%s/api/%s", callUrl, name), Component.class);
		
		return new ResponseEntity<Component>(comp, HttpStatus.OK);
	}
	
	@GetMapping(value="/{name}")
	public ResponseEntity<Component> getComponentInfo1depth(@PathVariable String name) throws Exception {

		LoggingUtil.logHeadersInfo(request);
		
		return new ResponseEntity<Component>(new Component.Builder(name, LocalDateTime.now(), depth).isFrontend(true).build(), HttpStatus.OK);
	}
	
}
