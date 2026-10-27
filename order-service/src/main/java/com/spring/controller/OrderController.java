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
import com.spring.dto.OrderDto;
import com.spring.entity.Order;
import com.spring.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/addOrder")
	public OrderDto saveOrder(@RequestBody Order order) throws JsonProcessingException
	{
		logger.info("saveOrder " + new ObjectMapper().writeValueAsString(order));
		return service.addOrder(order);
	}
}
