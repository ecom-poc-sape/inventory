package com.sapient.inventory.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Inventory {

	@Id
	private String id;
	private String productId;
	private String wireHouseLoc;
	private int quantity;
	
	
	public Inventory(String productId, String wireHouseLoc, int quantity) {
		super();
		this.productId = productId;
		this.wireHouseLoc = wireHouseLoc;
		this.quantity = quantity;
	}
	
	public Inventory() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
