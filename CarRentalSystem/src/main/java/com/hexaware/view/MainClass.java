package com.hexaware.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.hexaware.controller.CustomerController;
import com.hexaware.dao.ICarLeaseRepository;
import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.model.Customer;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		LoginView loginView = new LoginView();
		Scanner scan = new Scanner(System.in);
		Customer customer = new Customer();
		CustomerController customercontroller = new CustomerController();
		ICarLeaseRepository clr = new ICarLeaseRepositoryImpl();
		while (true) {
			System.out.println("***************************************");
			System.out.println("Registered Customer-----------------------> 1");
			System.out.println("New Registration--------------------------> 2");
			System.out.println("EXIT---------------------------------> 0");
			System.out.println("*********CHOOSE**********");
			System.out.print("Give the NO :----------->");

			int input = scan.nextInt();
			if (input==0)
			{
				System.out.println("#############################");
				System.out.println("#############################");
				System.out.println("#####THANK YOU fOR VISIT#####");
				System.out.println("#############################");
				System.out.println("#############################");
				break;
			}
			switch (input) {
			case 1: {

				System.out.println("***************************************");
				System.out.println("--------------***LOGIN***--------------");
				System.out.println("***************************************");
				System.out.println("CUSTOMER MAIL ID----------------------");
				String email = scan.next();
				customer.setEmail(email);

				customer = clr.findCustomerByEmailid(customer);
				boolean login = customer.isAuthentication();
				if (login) {
					
					loginView.display(email);
				}
				continue;
			}
				
			case 2: {
				System.out.println("***************************************");
				System.out.println("--------------***SIGN-UP***------------");
				System.out.println("***************************************");
				customercontroller.Cus();
				continue;

			}
			
			default: {
				System.out.println("###########-->INVALID CHOOSE<--##################");
			}

			}
		}

	}
}
