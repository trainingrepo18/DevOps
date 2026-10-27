package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.entity.Payment;
import com.spring.service.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	private PaymentService service;
	
	@PostMapping("/doPayment")
	public Payment addPayment(@RequestBody Payment payment) throws JsonProcessingException
	{
		logger.info("addPayment " + new ObjectMapper().writeValueAsString(payment));
		return service.addPayment(payment);
	}
}
