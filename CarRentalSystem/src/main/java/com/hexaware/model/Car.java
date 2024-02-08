package com.hexaware.model;
//Class for Car
/**
 * 
 */
public class Car {
	private int id;
	private String make; 
	private String model;
	private int year;
	private double dailyRate;
	private String status;
	private int passCap;
	private int engCap;
	private boolean authenticate;
	
//	Constructor for car without params
	public Car() {}
//	Constructor for car without params	
	
	public Car(String make, String model, int year, double dailyRate, String status, int passCap, int engCap) {
//		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.dailyRate = dailyRate;
		this.status = status;
		this.passCap = passCap;
		this.engCap = engCap;
	}
//	fuction to setCarDetails

	/**
	 * @param id
	 * @param make
	 * @param model
	 * @param year
	 * @param dailyRate
	 * @param status
	 * @param passCap
	 * @param engCap
	 */
	public void setCarDetails(int id, String make, String model, int year, double dailyRate, String status, int passCap, int engCap) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.dailyRate = dailyRate;
		this.status = status;
		this.passCap = passCap;
		this.engCap = engCap;
	}
	
//	a boolean method
	public boolean isAuthenticate() {
		return authenticate;
	}
	
//	getters and setters
	public void setAuthenticate(boolean authenticate) {
		this.authenticate = authenticate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPassCap() {
		return passCap;
	}
	public void setPassCap(int passCap) {
		this.passCap = passCap;
	}
	public int getEngCap() {
		return engCap;
	}
	public void setEngCap(int engCap) {
		this.engCap = engCap;
	}
}
