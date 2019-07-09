package com.dukzux.hystrix.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ClientServiceImpl implements ClientService {

	
	@HystrixCommand(fallbackMethod = "getDefaultGreeting", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
	@Override
	public String getGreeting(String name) {
		
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://localhost:8080/server/" + name);

	    return restTemplate.getForObject(uri, String.class);
		
	}
	
	public String getDefaultGreeting(String name) {
		return "Greeting from Circuit Breaker";
	}
	
}
