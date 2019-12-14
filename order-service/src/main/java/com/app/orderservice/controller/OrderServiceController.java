package com.app.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {

	@Autowired
	Environment environment;

	@GetMapping("/orderProduct/{name}")
	public String orderProduct(@PathVariable String name) {

		if (name.equals("Bus")) {
			throw new RuntimeException();
		}
		String port = environment.getProperty("server.port");
		String welcomMsg = environment.getProperty("orderservice.welcome");
		return welcomMsg + " The " + name + " has ordered and confirmed on the server port: " + port;
	}
}
