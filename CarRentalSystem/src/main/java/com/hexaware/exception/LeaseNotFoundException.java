package com.hexaware.exception;

public class LeaseNotFoundException extends Exception {
	public LeaseNotFoundException(String message) {
        super(message);
    }
	public String toString() {
		return "LeaseNotFoundException[]";
	}
}
