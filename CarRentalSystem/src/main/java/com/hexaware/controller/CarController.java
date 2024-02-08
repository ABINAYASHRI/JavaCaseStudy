package com.hexaware.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.ICarLeaseRepository;
import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.model.Car;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;

/**
 *		THE CAR CONTROLLER WHICH PROVIDES
 *		SERVICES NEEDED FOR CAR MANAGEMENT 
 *
 *
 *
 *
 */
public class CarController implements CarInterface {
	Lease lease = new Lease();
	ICarLeaseRepository clr = new ICarLeaseRepositoryImpl();
	Customer customer = new Customer();
	Scanner scan = new Scanner(System.in);
	
	// ########################### GET CAR ##################################//

		public void printcar(Car car) {
//			System.out.println("Car ID ------------> : " + car.getId());
			System.out.println("Car Make----------->: " + car.getMake());
			System.out.println("Car Model---------->: " + car.getModel());
			System.out.println("Car Year----------->: " + car.getYear());
			System.out.println("Daily Rate--------->: " + car.getDailyRate());
			System.out.println("Status-------------> : " + car.getStatus());
			System.out.println("Passanger capacity->: " + car.getPassCap());
			System.out.println("Engine Capacity---->: " + car.getEngCap());
			System.out.println("----------------------------------\n");
		}
		// ########################### NEW CAR ##################################//
		public void newCar() throws SQLException {
			Car car = new Car();
			System.out.println("Create Make--------------->");

			car.setMake(scan.next());
			System.out.println("create model-------------->");
			car.setModel(scan.next());

			System.out.println("SetYear------------------->");
			car.setYear(Integer.valueOf(scan.next()));

			System.out.println("DailyRate----------------->");
			car.setDailyRate(Integer.valueOf(scan.next()));

			System.out.println("Car is available press--> 1");
			System.out.println("Car is rented press------>2");

			System.out.println("Status-------------------->");

			int status = scan.nextInt();
			switch (status) {
			case 1:
				car.setStatus("Available");

			case 2:
				car.setStatus("Rented");
			default:
				car.setStatus("Available");
			}

			System.out.println("Passenger Capacity------->");
			car.setPassCap(Integer.valueOf(scan.next()));

			System.out.println("Engine Capacity---------->");
			car.setEngCap(Integer.valueOf(scan.next()));

			clr.addCar(car);
			printcar(car);

		}
		// ########################### AVAILABLE CARS ##################################//

		public void avaCars() throws SQLException {
			List<Car> cars = clr.listAvailableCars();
			for (Car c : cars) {
				printcar(c);

			}
		}
		// ########################### RENTED CARS ##################################//

		public void rentCars() throws SQLException {
			List<Car> rcars = clr.listRentedCars();
			for (Car rc : rcars) {
				printcar(rc);
			}
		}
}
