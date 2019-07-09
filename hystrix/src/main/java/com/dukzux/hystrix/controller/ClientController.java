package com.dukzux.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dukzux.hystrix.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/{name}")
	public String getGreetingFromServer(@PathVariable String name) {

		return this.clientService.getGreeting(name);
		
	}
	
}
