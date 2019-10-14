package com.sapient.inventory;

import org.springframework.http.HttpStatus;

public class InventoryResponse {
	
	HttpStatus status;
	String errorMessage;
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
