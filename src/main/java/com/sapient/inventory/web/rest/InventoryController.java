package com.sapient.inventory.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.inventory.InventoryResponse;
import com.sapient.inventory.domain.Inventory;
import com.sapient.inventory.service.InventoryService;


@RestController
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/items")
	public List<Inventory> getItemList(){	
		return inventoryService.getItemList();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/items")
	public ResponseEntity<InventoryResponse> addItemList(@RequestBody Inventory inventoryPojo) {
		InventoryResponse ir  = inventoryService.addInventoryItem(inventoryPojo);
		return new ResponseEntity<InventoryResponse>(ir, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/items/{id}")
	public ResponseEntity<InventoryResponse> updateItemList(@RequestParam Long id,
															@RequestBody Inventory inventoryPojo){
		InventoryResponse ir  = inventoryService.updateInventoryItem(id, inventoryPojo);
		return new ResponseEntity<InventoryResponse>(ir, HttpStatus.ACCEPTED);
	}


	@DeleteMapping("/items/{id}")
	public ResponseEntity<InventoryResponse> deleteItemList(@RequestParam Long id){
		InventoryResponse ir  = inventoryService.deleteInventoryItem(id);
		return new ResponseEntity<InventoryResponse>(ir, HttpStatus.OK);
	}
}
