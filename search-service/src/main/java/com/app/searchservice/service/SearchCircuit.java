package com.app.searchservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SearchCircuit {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "callOrderServiceFallback")
	public String callOrderService(String name) {
		System.out.println("callOrderService() method called for:" + name);
		String response = restTemplate.getForObject("http://OrderService/OrderService/orders/orderProduct/" + name,
				String.class);
		return response;

	}

	public String callOrderServiceFallback(String name) {
		System.out.println("callOrderServiceFallback() method called for:" + name);
		return new String();
	}

}
