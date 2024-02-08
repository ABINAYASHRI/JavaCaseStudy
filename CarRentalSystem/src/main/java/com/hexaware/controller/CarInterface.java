package com.hexaware.controller;

import java.sql.SQLException;

import com.hexaware.model.Car;

public interface CarInterface {
	
	public void printcar(Car car);
	public void newCar() throws SQLException;
	public void avaCars() throws SQLException;
	public void rentCars() throws SQLException;
	
	
}
