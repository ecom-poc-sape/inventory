package com.sapient.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

@ControllerAdvice
public class BaseControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<InventoryResponse> handelException() {
		InventoryResponse ir = new InventoryResponse();
		ir.setErrorMessage("Internal Server error");
		ir.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<InventoryResponse>(ir,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
