package com.hexaware.controller;

import java.sql.SQLException;

import com.hexaware.model.Lease;
import com.hexaware.model.Payment;

public interface PaymentInterface {
	
	public void payments(Payment payment);
	public void recordPayment(Payment payment, Lease lease) throws SQLException;
	public void printPayment() throws SQLException;
	public void listPayment() throws SQLException;

}
