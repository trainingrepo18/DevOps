package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.spring.client.ApiClient;
import com.spring.dto.OrderDto;
import com.spring.dto.Payment;
import com.spring.entity.Order;
import com.spring.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webCBuilder;
	
	@Autowired
	private ApiClient apiClient;
	
	@Override
	public OrderDto addOrder(Order order) {
		// TODO Auto-generated method stub
		
		Order  orderResponse = repo.save(order);
		/*
		 * Payment body = new Payment(); 
		 * body.setStatus("Failure");
		 * body.setTransactionId("ssssdddddd");
		 */
		//Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", new Payment(), Payment.class);
		
		Payment paymentResponse = webCBuilder.baseUrl("http://PAYMENT-SERVICE").build()
				.post().uri("/payment/doPayment")
				.bodyValue(new Payment())
				.retrieve()
				.toEntity(Payment.class)
				.block()
				.getBody();
		
		//Payment paymentResponse = apiClient.addPayment(new Payment());
									
		OrderDto dto =  new OrderDto();
		dto.setOrderId(orderResponse.getOrderId());
		dto.setOrderName(orderResponse.getOrderName());
		dto.setPaymentId(paymentResponse.getPaymentId());
		dto.setPrice(orderResponse.getPrice());
		dto.setQty(orderResponse.getQty());
		dto.setStatus(paymentResponse.getStatus());
		dto.setTransactionId(paymentResponse.getTransactionId());
		return dto;
	}

}
