package com.hexaware.model;

public class Customer {
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String phoneNo;
	private boolean authentication;
	private boolean auth;
	
	public Customer() {}
	
	public Customer(String fName, String lName, String email, String phoneNo) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public boolean isAuth() {
		return auth;
	}
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	public boolean isAuthentication() {
		return authentication;
	}
	public void setAuthentication(boolean authentication) {
		this.authentication = authentication;
	}
	public void setCustomerDetails(int id, String fName, String lName, String email, String phoneNo) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

//	public void setEmail(String email) {
		// TODO Auto-generated method 
//		this.email = email;
		
	
	
}
