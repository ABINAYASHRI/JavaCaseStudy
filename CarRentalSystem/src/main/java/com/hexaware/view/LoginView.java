package com.hexaware.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.hexaware.controller.CustomerController;
import com.hexaware.dao.ICarLeaseRepository;
import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.model.Customer;

public class LoginView {

	Customer customer = new Customer();
	ICarLeaseRepository clr = new ICarLeaseRepositoryImpl();
	Scanner scan = new Scanner(System.in);
	CustomerController customercontroller=new CustomerController();

	public void display(String mail) throws SQLException {
		String email=mail;
		while(true)
		{
			System.out.println("***************************************");
			System.out.println("CUSTOMER MANAGEMENT--------------->1");
			System.out.println("CAR MANAGEMENT-------------------->2");
			System.out.println("LEASE MANAGEMENT------------------>3");
			System.out.println("PAYMENT DETAILS------------------->4");
			System.out.println("EXIT------------------------------>0");
			System.out.println("***************************************");
			System.out.println("*********CHOOSE**********");
			System.out.print("Give the NO :------------->");
			int input=scan.nextInt();
			if (input==0)
			{
				break;
			}
			switch(input)
			{
			case 1:
			{
				CustomerView customerView=new CustomerView();
				customerView.display(email);
				continue;
			}
			case 2:
			{
				CarView carView =new CarView();
				carView.display();
				continue;
			}
			case 3:
			{
				LeaseView leaseView=new LeaseView();
				leaseView.display();
				continue;
			}
			case 4:
			{
				
				PaymentView paymentView= new PaymentView();
				paymentView.display();
				
				continue;
			}
			
				default:
				{
					System.out.println("###########-->INVALID CHOOSE<--##################");
				}
			}
		}
		
		
		}

	}

