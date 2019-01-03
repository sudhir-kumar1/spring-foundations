package com.poc.chap1.common.service;

import java.util.Map;

import com.poc.chap1.common.domain.Product;

public interface InventoryService {
	Map<Product, Long> getTotalInventoryOnHand();

	long getQuantityOnHand(String itemId);

	void adjustInventory(String itemId, long quantity);
}
