package com.spring.service;

import com.spring.dto.OrderDto;
import com.spring.entity.Order;

public interface OrderService {

	OrderDto addOrder(Order order);
}
