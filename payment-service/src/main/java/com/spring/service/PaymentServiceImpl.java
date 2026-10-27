package com.spring.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Payment;
import com.spring.repo.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepo repo;
	
	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		payment.setStatus(new Random().nextBoolean()?"SUCCESS":"FAILURE");
		payment.setTransactionId(UUID.randomUUID().toString());
		return repo.save(payment);
	}

}
