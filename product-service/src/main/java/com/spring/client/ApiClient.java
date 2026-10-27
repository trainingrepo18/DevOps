package com.spring.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.dto.Order;


@FeignClient(name = "ORDER-SERVICE")
public interface ApiClient {

	@PostMapping("order/addOrder")
	public Order saveOrder(@RequestBody Order order);
}
