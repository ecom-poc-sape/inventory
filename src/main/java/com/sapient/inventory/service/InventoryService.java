package com.sapient.inventory.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sapient.inventory.InventoryResponse;
import com.sapient.inventory.domain.Inventory;
import com.sapient.inventory.domain.InventoryRepository;

/**
 * Hello world!
 *
 */
@Service
public class InventoryService 
{
	
    @Autowired
	private InventoryRepository inventoryRepository;
	
    @PostConstruct
	public void init() {
    	inventoryRepository.save(new Inventory("product-1", "Bangalore", 1));
		
		  inventoryRepository.save(new Inventory("product-2", "Bangalore", 2));
		  inventoryRepository.save(new Inventory("product-3", "Mumbai", 3));
		  inventoryRepository.save(new Inventory("product-4", "Mumbai", 4));
		 
	} 
    
    
	public List<Inventory> getItemList() {
		// TODO Auto-generated method stub
		List<Inventory> list = (List<Inventory>) inventoryRepository.findAll();
		return list;
	}

	
	public InventoryResponse addInventoryItem(Inventory inventory) {
		
		// InventoryResponse
		inventoryRepository.save(inventory);
		return new InventoryResponse(HttpStatus.ACCEPTED, "created");
	}


	public InventoryResponse updateInventoryItem(Long id, Inventory inventory) {
		// TODO Auto-generated method stub
		Optional<Inventory> inventory1 = inventoryRepository.findById(id);
		inventory.setId(id);
		inventoryRepository.save(inventory);
		
		return new InventoryResponse(HttpStatus.ACCEPTED, "Updated inventory successfully");

	}


	public InventoryResponse deleteInventoryItem(Long id) {
		// TODO Auto-generated method stub
		inventoryRepository.deleteById(id);
		
		return new InventoryResponse(HttpStatus.ACCEPTED, "Updated inventory successfully");	
	}
	
}
