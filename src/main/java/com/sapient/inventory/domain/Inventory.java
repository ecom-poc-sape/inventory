package com.sapient.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {

	@Id
	Long id;
	String productId;
	String wireHouseLoc;
	int quantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getWireHouseLoc() {
		return wireHouseLoc;
	}
	public void setWireHouseLoc(String wireHouseLoc) {
		this.wireHouseLoc = wireHouseLoc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
