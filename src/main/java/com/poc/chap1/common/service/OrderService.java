package com.poc.chap1.common.service;

import java.util.Map;

import com.poc.chap1.common.domain.Customer;
import com.poc.chap1.common.domain.Order;

public interface OrderService {
	Order createOrder(Customer customer, Map<String, Long> items);

	Order createOrder(String customerId, Map<String, Long> items);

	Order getOrder(String orderId);
}
