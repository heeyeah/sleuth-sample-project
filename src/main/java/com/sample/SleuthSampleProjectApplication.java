package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@EnableBinding(Sink.class)
@SpringBootApplication
public class SleuthSampleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthSampleProjectApplication.class, args);
	}

	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@StreamListener(target = Sink.INPUT)
	public void processCheapMeals(String meal) {
		System.out.println("This was a great meal!: " + meal);
	}
}
