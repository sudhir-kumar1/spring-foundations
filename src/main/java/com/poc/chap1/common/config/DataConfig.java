package com.poc.chap1.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poc.chap1.common.data.repository.CustomerRepository;
import com.poc.chap1.common.data.repository.InventoryItemRepository;
import com.poc.chap1.common.data.repository.SalesOrderRepository;

@Configuration
public class DataConfig {
	@Bean
	public InventoryItemRepository inventoryItemRepository() {
		return new InventoryItemRepository();
	}

	@Bean
	public CustomerRepository customerRepository() {
		return new CustomerRepository();
	}

	@Bean
	public SalesOrderRepository salesOrderRepository() {
		return new SalesOrderRepository();
	}
}
