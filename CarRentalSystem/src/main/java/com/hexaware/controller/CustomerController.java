package com.hexaware.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.ICarLeaseRepository;
import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;

public class CustomerController implements CustomerInterface {

	Lease lease = new Lease();
	ICarLeaseRepository clr = new ICarLeaseRepositoryImpl();
	Customer customer = new Customer();
	Scanner scan = new Scanner(System.in);

	// ################ GET NEW CUSTOMER ############//

	public void printcustomer(Customer customer) {
//		System.out.println("CuastomerId : " + customer.getId());
		System.out.println("First Name  : " + customer.getfName());
		System.out.println("Last Name   : " + customer.getlName());
		System.out.println("Email       : " + customer.getEmail());
		System.out.println("PhoneNO    : " + customer.getPhoneNo());
		System.out.println("----------------------------------\n");
	}

	// ################ SET NEW CUSTOMER ############//

	public void Cus() throws SQLException {
		try {
			System.out.print("First Name------>");
			customer.setfName(scan.next());
			System.out.print("Last Name------->");
			customer.setlName(scan.next());
			System.out.print("Email----------->");
			customer.setEmail(scan.next());
			System.out.print("Phone number---->");
			customer.setPhoneNo(scan.next());
			clr.addCustomer(customer);
			printcustomer(customer);
		} catch (Exception e) {
			System.out.print(e);
		}

	}

	// ################ ALLCUSTOMER ############//
	public void allCustomer() throws SQLException {
		List<Customer> cust = clr.listCustomers();
		for (Customer c : cust) {
			printcustomer(c);
		}
	}

}
