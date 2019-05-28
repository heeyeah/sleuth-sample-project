package com.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${sample.callUrl.backend}")
	private String callUrl;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	RestTemplate restTemplate;
		
	@GetMapping(value="/web/{name}")
	public String arriveBackend(@PathVariable String name) throws Exception {

		LoggingUtil.logHeadersInfo(request);
		
		return restTemplate.getForObject(String.format("%s/back/%s", callUrl, name), String.class);
	}
	
	@GetMapping(value="/web/last/{name}")
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
