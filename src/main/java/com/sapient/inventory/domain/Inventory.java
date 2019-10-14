package com.sapient.inventory.domain;

public class Inventory {

	String productId;
	String wireHouseLoc;
	int quantity;
	
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
