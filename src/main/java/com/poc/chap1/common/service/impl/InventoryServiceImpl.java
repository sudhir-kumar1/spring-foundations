package com.poc.chap1.common.service.impl;

import java.util.Map;

import com.poc.chap1.common.data.repository.InventoryItemRepository;
import com.poc.chap1.common.domain.Product;
import com.poc.chap1.common.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {
	private final InventoryItemRepository inventoryItemRepository;

	public InventoryServiceImpl(InventoryItemRepository inventoryItemRepository) {
		this.inventoryItemRepository = inventoryItemRepository;
	}

	public Map<Product, Long> getTotalInventoryOnHand() {
		return null;
	}

	public long getQuantityOnHand(String itemId) {
		return 0;
	}

	public void adjustInventory(String itemId, long quantity) {

	}
}
