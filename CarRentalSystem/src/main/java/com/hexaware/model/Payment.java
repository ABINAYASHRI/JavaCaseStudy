package com.hexaware.model;

public class Payment {
	public void setPayment(int leaseId, double amount) {
		
		this.leaseId = leaseId;
		
		this.amount = amount;
	}
	private int leaseId;
	private String payDate;
	private double amount;
	private int payment;
	
	
	
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
