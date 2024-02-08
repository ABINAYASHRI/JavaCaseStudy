package com.hexaware.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.exception.LeaseNotFoundException;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;
import com.hexaware.model.Payment;

public class PaymentController implements PaymentInterface {
	Lease lease = new Lease();
	ICarLeaseRepositoryImpl clr = new ICarLeaseRepositoryImpl();
	Customer customer = new Customer();
	Scanner scan = new Scanner(System.in);

	// *************************************PAYMENT
	// DETAIL*********************************//

	// ########### PRINT PAYMENT #############

	

	public void recordPayment(Payment payment, Lease lease) throws SQLException {
		payment.setLeaseId(lease.getId());
		System.out.println("lease ID :" + lease.getId());
		System.out.println("Payment Date:" + payment.getPayDate());
		payment.setAmount(lease.getAmount());
		System.out.println("Amount:" + lease.getAmount());
		clr.recordPayment(lease, payment);
		System.out.println("----------------------------------\n");
	}
	// ########################### PAYMENTS ##################################//

	public void payments(Payment payment) {

		System.out.println("*************************************");
		System.out.println("PaymentID-----> " + payment.getPayment());
		System.out.println("leaseID-----> " + payment.getLeaseId());
		System.out.println("payDate-----> " + payment.getPayDate());
		System.out.println("amount------> " + payment.getAmount());
		System.out.println("*************************************");


	}

	public void listPayment() throws SQLException {
		
		List<Payment> leasess = clr.listPayment();
		for (Payment l1 : leasess) {
			payments(l1);
		}
	}

	public void printPayment() throws SQLException {
		// TODO Auto-generated method stub
		try {
			System.out.println("LeaseID-------->");
			int leaseid = scan.nextInt();
			
		
			lease = clr.findLeaseById(leaseid);

			boolean log = lease.isAuth();
			if (log) {
				clr.Paymentid(leaseid);
				} else {
					throw new LeaseNotFoundException("Payment Not Found");
			}
		}
		catch(LeaseNotFoundException e)
		{
			System.out.println(e.getMessage());
			//System.out.println("Payment Not Found");

			
		}
		
	}

}
