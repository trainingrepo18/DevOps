package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.ApiClient;
import com.spring.dto.Order;
import com.spring.dto.ProductDto;
import com.spring.entity.Product;
import com.spring.repo.ProductRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private ApiClient apiClient;
	@Override
	@CircuitBreaker(name = "order-service",fallbackMethod = "fallBackForApiCall")
	public ProductDto addProduct(Product product) {
		// TODO Auto-generated method stub
		Product productResponse = repo.save(product);
		
		Order body = new Order();
		body.setOrderName(product.getProductName());
		body.setQty(product.getQty());
		body.setPrice(product.getPrice());
		
		Order orderResponse = apiClient.saveOrder(body);
		
		ProductDto dto =  new ProductDto();
		
		dto.setOrderId(orderResponse.getOrderId());
		dto.setOrderName(orderResponse.getOrderName());
		dto.setPaymentId(orderResponse.getPaymentId());
		dto.setPrice(orderResponse.getPrice());
		dto.setProductId(productResponse.getProductId());
		dto.setProductName(productResponse.getProductName());
		dto.setQty(productResponse.getQty());
		dto.setStatus(orderResponse.getStatus());
		dto.setTransactionId(orderResponse.getTransactionId());
		
		return dto;
	}

		public ProductDto fallBackForApiCall(Product product, Exception ex)
		{
			return new ProductDto(0, product.getProductName(), 0, product.getProductName(),
					product.getQty(), product.getPrice(), 0, "Order service is taking too long time to respond", "XXXXX");
			
		}
}
