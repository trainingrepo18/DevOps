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
import com.spring.dto.ProductDto;
import com.spring.entity.Product;
import com.spring.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public ProductDto addProduct(@RequestBody Product product) throws JsonProcessingException
	{
		logger.info("addProduct " + new ObjectMapper().writeValueAsString(product));
		return service.addProduct(product);
	}
}
