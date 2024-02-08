package com.hexaware.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.hexaware.controller.CustomerController;
import com.hexaware.dao.ICarLeaseRepository;
import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;

public class CustomerView {
	
	Lease lease = new Lease();
	ICarLeaseRepository clr = new ICarLeaseRepositoryImpl();
	Customer customer = new Customer();
	Scanner scan = new Scanner(System.in);
	CustomerController customercontroller=new CustomerController();
	
	
	public void display(String email) throws SQLException {
		customer.setEmail(email);
		while (true) {
			
			System.out.println("***************************************");
//			System.out.println("CUSTOMER PROFILE---------->4");
			System.out.println("ALL CUSTOMER DETAIL------->1");
			System.out.println("CUSTOMER SEARCH ---------->2");
			System.out.println("REMOVE CUSTOMER----------->3");
			System.out.println("BACK---------------------->0");
			System.out.println("***************************************");
			System.out.println("*********CHOOSE**********");
			System.out.print("Give the NO :----------->");
			int rem = scan.nextInt();
			if (rem == 4) {
				System.out.println("**********ADD CUSTOMER***********");
				System.out.print("CUSTOMER ID-----------> ");

				clr.findCustomerByEmailid(customer);
				System.out.println("*************************************");

			} else if (rem == 1) {
				System.out.println("*********ALL CUSTOMER DETAIL***********");
				customercontroller.allCustomer();
				System.out.println("***************************************");
			} else if (rem == 2) {
				System.out.println("****************SEARCH*****************");
				System.out.print("CUSTOMER ID--------------------->");
				int search = scan.nextInt();
				clr.findCustomerById(search);
			} else if (rem == 3) {
				System.out.print("CUSTOMER ID--------------------->");

				int sign = scan.nextInt();
				clr.removeCustomer(sign);
				System.out.println("**************************************");
			} else if (rem == 0) {
				System.out.println("***************************************");
				break;

			} else {
				System.out.println("###########-->INVALID CHOOSE<--##################");
			}
		}
		
	}
	

}
