package com.sample.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.Component;
import com.sample.util.LoggingUtil;

import brave.sampler.Sampler;

@CrossOrigin
@RestController
@RequestMapping("/module")
public class Module {

	private static final int depth = 3;
	
	@Autowired
	HttpServletRequest request;
	
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@GetMapping("/{name}/desc")
	public Component printComponentDesc(@PathVariable String name) throws Exception {
		
		LoggingUtil.logHeadersInfo(request);
		
		return new Component.Builder(name, LocalDateTime.now(), depth).isModule(true).desc("printComponent").build();
	}
	
	@GetMapping("/{name}/version")
	public Component printComponentVersion(@PathVariable String name) throws Exception {
		
		LoggingUtil.logHeadersInfo(request);
		
		return new Component.Builder(name, LocalDateTime.now(), depth).isModule(true).version("v2").build();
	}
}
