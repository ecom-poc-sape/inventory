package com.sapient.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sapient.inventory.InventoryResponse;
import com.sapient.inventory.domain.Inventory;
import com.sapient.inventory.domain.Product;
import com.sapient.inventory.repository.InventoryRepository;
import com.sapient.inventory.repository.ProductRepository;

/**
 * Hello world!
 *
 */
@Service
public class InventoryService 
{
	
    @Autowired
	private InventoryRepository inventoryRepository;
	
    @Autowired
	private ProductRepository productRepository;
    
    @PostConstruct
	public void init() {
    	  		 
		  productRepository.save((new Product("Mac Book", 5000d, "laptop")));
		  productRepository.save((new Product("lenovo", 4000d, "desk top")));
		  productRepository.save((new Product("Think Pad", 6000d, "laptop")));
		  productRepository.save((new Product("HP Pavilion", 7000d, "Tab")));
		  
		  List<Product> products = productRepository.findAll();
		  inventoryRepository.save(new Inventory(products.get(0).getId(), "Bangalore", 5));
		  inventoryRepository.save(new Inventory(products.get(1).getId(), "Bangalore", 10));
		  inventoryRepository.save(new Inventory(products.get(2).getId(), "Mumbai", 3));
		  inventoryRepository.save(new Inventory(products.get(3).getId(), "Mumbai", 4));

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


	public InventoryResponse updateInventoryItem(String id, Inventory inventory) {
		// TODO Auto-generated method stub
		//Inventory inventory1 = inventoryRepository.findAllById(id);
		inventory.setId(id);
		inventoryRepository.save(inventory);
		
		return new InventoryResponse(HttpStatus.ACCEPTED, "Updated inventory successfully");

	}


	public InventoryResponse deleteInventoryItem(String id) {
		// TODO Auto-generated method stub
		inventoryRepository.deleteById(id);
		
		return new InventoryResponse(HttpStatus.ACCEPTED, "Deleted item from inventory successfully");	
	}


	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		List<Product> list = (List<Product>) productRepository.findAll();
		List<Product> availableList = new ArrayList<Product>();
		for(Product p  : list) {
			List<Inventory> in = inventoryRepository.findByProductId(p.getId());
			if(in.get(0).getQuantity() > 0) {
				availableList.add(p);
			}
		}
		return availableList;
	}


	public InventoryResponse addProductItem(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		return new InventoryResponse(HttpStatus.ACCEPTED, "added new product success fully");
	}


	public InventoryResponse deleteProduct(String id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		return new InventoryResponse(HttpStatus.ACCEPTED, "Deleted item from Product successfully");	

	}


	public InventoryResponse updateInventoryProducts(String products, String task) {
		// TODO Auto-generated method stub
		String [] strs = products.split(",");
		if (task.contentEquals("add")) {
			for(String s : strs) {
				List<Inventory> in = inventoryRepository.findByProductId(s);
				in.get(0).setQuantity(in.get(0).getQuantity() + 1);
				inventoryRepository.save(in.get(0));
			}
		} else {
			for(String s : strs) {
				List<Inventory> in = inventoryRepository.findByProductId(s);
				in.get(0).setQuantity(in.get(0).getQuantity() - 1);
				inventoryRepository.save(in.get(0));
			}
		}
		return new InventoryResponse(HttpStatus.ACCEPTED, "Updated inventory successfully");
	}
	
}
