package com.hexaware.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.hexaware.controller.CarController;
import com.hexaware.controller.CustomerController;
import com.hexaware.dao.ICarLeaseRepository;
import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;

public class CarView {
	Lease lease = new Lease();
	ICarLeaseRepository clr = new ICarLeaseRepositoryImpl();
	Customer customer = new Customer();
	Scanner scan = new Scanner(System.in);
	CarController carController=new CarController();
	CustomerController customercontroller=new CustomerController();
	public void display() throws SQLException
	{
		
		while (true) {
			System.out.println("ADD NEW CAR------------------->1");
			System.out.println("REMOVE THE CAR---------------->2");
			System.out.println("AVAILABLE CARS---------------->3");
			System.out.println("RENTED CARS------------------->4");
			System.out.println("SEARCH THE CAR---------------->5");
			System.out.println("BACK-------------------------->0");
			System.out.println("*********CHOOSE**********");
			System.out.print("Give the NO :----------->");
			int carInt = scan.nextInt();
			if (carInt == 1) {
				System.out.println("***************************************");
				carController.newCar();
				System.out.println("***************************************");
			} else if (carInt == 2) {
				System.out.println("***************************************");
				System.out.print("CAR ID------------------------------>");
				int carid = scan.nextInt();
				clr.removeCar(carid);
				System.out.println("***************************************");
			} else if (carInt == 3) {
				System.out.println("***************************************");
				System.out.println("===========AVAILABLE CARS==============");
				carController.avaCars();
				System.out.println("***************************************");
			} else if (carInt == 4) {
				System.out.println("***************************************");
				System.out.println("=============RENTED CAR================");
				carController.rentCars();
				System.out.println("***************************************");
			} else if (carInt == 5) {
				System.out.println("***************************************");
				System.out.println("===========SEARCH A CAR==============");
				System.out.print("CAR ID ------------------------> ");
				int fcar = scan.nextInt();
				clr.findCarById(fcar);
				System.out.println("***************************************");
			} else if (carInt == 0) {
				System.out.println("***************************************");
				break;
			} else {
				System.out.println("###########-->INVALID CHOOSE<--##################");
			}
		}
	}

}
