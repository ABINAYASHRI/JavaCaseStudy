package com.hexaware.exception;

public class CustomerNotFoundException extends Exception {
	
	 public CustomerNotFoundException(String message) {
	        super(message);
	    }
	 public String toString() {
			return "CustomerNotFoundException[]";
		}
}
