package com.dukzux.server.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/server")
public class ServerController {

	@GetMapping("/{name}")
	public String hello(@PathVariable String name) {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(5) + 1;
		
		log.info("sleep["+randomInt+"]");
		
		try {
			Thread.sleep(randomInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "hello: " + name;
		
	}
	
}
