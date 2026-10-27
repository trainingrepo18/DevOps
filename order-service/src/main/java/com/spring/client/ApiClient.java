package com.spring.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.dto.Payment;

@FeignClient(name = "PAYMENT-SERVICE")
public interface ApiClient {

	@PostMapping("/payment/doPayment")
	public Payment addPayment(@RequestBody Payment payment);
	
}
