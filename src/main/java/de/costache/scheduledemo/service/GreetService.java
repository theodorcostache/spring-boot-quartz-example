package de.costache.scheduledemo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetService {

	public String sayHello(String name) {
		return "Hello " + name + "!";
	}
}
