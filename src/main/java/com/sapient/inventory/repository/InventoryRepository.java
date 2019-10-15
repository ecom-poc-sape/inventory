package com.sapient.inventory.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.sapient.inventory.domain.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String>  {
	
	List<Inventory> findByProductId(String productId);

		


}
