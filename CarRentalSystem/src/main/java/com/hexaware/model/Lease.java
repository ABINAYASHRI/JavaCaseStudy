package com.hexaware.model;
// LEASE CLASS
public class Lease {
	private int id;
	private int vehicleId;
	private int custId;
	private String startDate;
	private String endDate;
	private String type;
	private double amount;
	private boolean auth;
//	CONSTRUCTOR WITH NO PARAMS
	public Lease() {}
	
//	constructor with params
	public Lease(int vid, int cid, String sdate, String edate, String type){
//		this.id=lid;
		this.vehicleId = vid;
		this.custId = cid;
		this.startDate = sdate;
		this.endDate = edate;
		this.type = type;
		
		
	}
//	isAuth
	
	public boolean isAuth() {
		return auth;
	}
//	Set Auth
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
// For setting lease details
	public void  setLeaseDetails(int id, int vehicleId, int custId, String startDate, String endDate,String type) {
		this.id = id;
		this.vehicleId = vehicleId;
		this.custId = custId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
	}
	// GET 
	public int getId() {
		return id;
	}
	// GET 
	public void setId(int id) {
		this.id = id;
	}
	// GET 
	public int getVehicleId() {
		return vehicleId;
	}
	// GET 
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	// GET 
	public int getCustId() {
		return custId;
	}
	/*SET*/
	public void setCustId(int custId) {
		this.custId = custId;
	}
//	SET
	public String getStartDate() {
		return startDate;
	}
//	SET
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
//	SET
	public String getEndDate() {
		return endDate;
	}
//	SET
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
//	GET
	public String getType() {
		return type;
	}
	
//	SET
	public void setType(String type) {
		this.type = type;
	}
//GET
	public double getAmount() {
		return amount;
	}
//SET
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
