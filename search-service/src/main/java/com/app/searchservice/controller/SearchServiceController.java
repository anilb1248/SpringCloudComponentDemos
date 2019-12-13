package com.app.searchservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
@RequestMapping("/search")
// @RibbonClient(name = "orderclientribbon")
/**
 * 
 * As we are using Eureka server,
 * 
 * @RibbonClient(name = "orderclientribbon") &
 * @Autowired // DiscoveryClient discoveryClient; are not required
 * 
 *
 */
public class SearchServiceController {

	@Autowired
	RestTemplate restTemplate;

	// @Autowired
	// DiscoveryClient discoveryClient;

	@GetMapping("/getProducts")
	public List<String> getProducts() {
		List<String> list = new ArrayList<String>();
		list.add("Car");
		list.add("Bike");
		list.add("Bus");

		return list;
	}

	@GetMapping("/order/{name}")
	public String orderProduct(@PathVariable String name) {
		// String response =
		// restTemplate.getForObject("http://orderclientribbon/OrderService/orders/orderProduct/"
		// + name, String.class);
		// String response =
		// restTemplate.getForObject("http://localhost:2030/OrderService/orders/orderProduct/"
		// + name, String.class);

		/*
		 * List<ServiceInstance> instances =
		 * discoveryClient.getInstances("OrderService"); ServiceInstance instance =
		 * instances.get(0); URI orderUri = instance.getUri();
		 * System.out.println("*************** " + orderUri);
		 * 
		 * String response = new RestTemplate().getForObject(orderUri +
		 * "/OrderService/orders/orderProduct/" + name, String.class);
		 */

		String response = restTemplate.getForObject("http://OrderService/OrderService/orders/orderProduct/" + name,
				String.class);

		return response;
	}
}
