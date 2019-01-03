package com.poc.chap1.common.service.impl;

import java.util.Map;

import com.poc.chap1.common.data.repository.CustomerRepository;
import com.poc.chap1.common.data.repository.SalesOrderRepository;
import com.poc.chap1.common.domain.Customer;
import com.poc.chap1.common.domain.Order;
import com.poc.chap1.common.service.InventoryService;
import com.poc.chap1.common.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private final InventoryService inventoryService;
	private final CustomerRepository customerRepository;
	private final SalesOrderRepository salesOrderRepository;

	public OrderServiceImpl(InventoryService inventoryService, CustomerRepository customerRepository,
			SalesOrderRepository salesOrderRepository) {
		this.inventoryService = inventoryService;
		this.customerRepository = customerRepository;
		this.salesOrderRepository = salesOrderRepository;
	}

	public Order createOrder(Customer customer, Map<String, Long> items) {
		return null;
	}

	public Order createOrder(String customerId, Map<String, Long> items) {
		return null;
	}

	public Order getOrder(String orderId) {
		return null;
	}
}
