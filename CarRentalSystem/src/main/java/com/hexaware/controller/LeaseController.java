package com.hexaware.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.exception.CarNotFoundException;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.model.Car;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;
import com.hexaware.model.Payment;

public class LeaseController implements LeaseInterface {
	Lease lease = new Lease();
	ICarLeaseRepositoryImpl clr = new ICarLeaseRepositoryImpl();
	Customer customer = new Customer();
	Car car = new Car();
	Scanner scan = new Scanner(System.in);
	Payment payment=new Payment();
	PaymentController paymentcontroller=new PaymentController();

	// ########################### SET LEASE ##################################//

	public void leases() throws SQLException {
//			Lease lease=new Lease();
		System.out.println();

		System.out.println("VEHICLE ID------------> ");
		try {
			int vehicle = scan.nextInt();
			car.setId(vehicle);
			car = clr.findCar(car);

			boolean log = car.isAuthenticate();
			if (log) {
				lease.setVehicleId(vehicle);
			} else {
				throw new CarNotFoundException("VEHICLE NOT FOUND");
			}

			System.out.println("CUSTOMER ID-----------> ");
			
				int custom = scan.nextInt();
				customer.setId(custom);
				customer = clr.findCustomer(customer);

				boolean cusid = customer.isAuth();
				if (cusid) {
					lease.setCustId(custom);

				} else {
					throw new CustomerNotFoundException("CUSTOMER NOT FOUND");
				}

			
			System.out.print("START DATE------------> ");
			String startdate = scan.next();
			lease.setStartDate(startdate);
			System.out.print("END DATE--------------> ");
			String enddate = scan.next();
			lease.setEndDate(enddate);

			double v = clr.addpayment(vehicle);

			

			System.out.println("Type------------------> ");
			System.out.println();

			System.out.println("DAILY BASES----------> 1");
			System.out.println();

			System.out.println("DAILY RENT---------->" + v);
			System.out.println();

			System.out.println("MONTHLY BASES--------> 2");
			System.out.println();

			System.out.println("MONTHLY BASES RENT---------->" + v * 30);
			System.out.println();
			
			System.out.print("CHOICE--------> ");

			int input = scan.nextInt();
			switch (input) {
			case 1:
				
				lease.setType("Daily");
				lease.setAmount(v);
				
			case 2:
				lease.setType("Monthly");
				lease.setAmount(v*30);
				break;
			default:
				lease.setType("Daily");
				lease.setAmount(v*30);
			}
			clr.UpdateCar(vehicle);
			clr.createLease(lease);
			clr.findLeaseId(vehicle);
			lease.setId(clr.leaseId(vehicle));
			paymentcontroller.recordPayment(payment, lease);
//			
//			
			

		}

		catch (CarNotFoundException e) {
			System.out.println(e.getMessage());
		}
		 catch (CustomerNotFoundException e) {
				System.out.println(e.getMessage());
			}

	}

	// ########################### SET LEASE ##################################//
	public void printlease(Lease lease) {
		System.out.println("lease ID :--->" + lease.getId());
		System.out.println("VehicleID:--->" + lease.getVehicleId());
		System.out.println("custId:------>" + lease.getCustId());
		System.out.println("startDate:--->" + lease.getStartDate());
		System.out.println("endDate:s :-->" + lease.getEndDate());
		System.out.println("type:s :----->" + lease.getType());
		System.out.println("----------------------------------\n");
	}

	// ########################### ACTIVE LEASE ##################################//

	public void activelease() throws SQLException {

		List<Lease> leases = clr.listActiveLeases();
		for (Lease l : leases) {
			printlease(l);
		}
	}

	public void historyLease(int customerID) throws SQLException {
		List<Lease> leasess = clr.historyLease(customerID);
		for (Lease l1 : leasess) {
			printlease(l1);
		}
	}
	
	
}
