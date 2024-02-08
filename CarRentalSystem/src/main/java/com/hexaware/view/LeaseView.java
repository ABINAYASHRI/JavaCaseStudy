package com.hexaware.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.hexaware.controller.LeaseController;
import com.hexaware.controller.LeaseInterface;
import com.hexaware.dao.ICarLeaseRepository;
import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;

public class LeaseView {
	Lease lease = new Lease();
	ICarLeaseRepository clr = new ICarLeaseRepositoryImpl();
	Customer customer = new Customer();
	Scanner scan = new Scanner(System.in);
	LeaseInterface leaseController = new LeaseController();

	public void display() throws SQLException {
		while (true) {
			System.out.println("CREATE LEASE----------------->1");
			System.out.println("LEASE INFO------------------->2");
			System.out.println("ACTIVE LEASE----------------->3");
			System.out.println("LEASE HISTORY---------------->4");
			System.out.println("EXIT------------------------->0");
			System.out.println("*********CHOOSE**********");
			System.out.print("GIVE ME YOUR NO:----------->");
			int leasess = scan.nextInt();
			if (leasess == 1) {

				System.out.println("************CREATE NEW LEASE**************");
				leaseController.leases();
				System.out.println("******************************************");

			} else if (leasess == 2) {

				System.out.println("****************LEASE INFO****************");
				System.out.println("******************");
				System.out.print("LEASE ID :----------->");
				int les = scan.nextInt();
				clr.findLease(les);
				System.out.println("******************************************");

			} else if (leasess == 3) {

				System.out.println("************ACTIVE LEASE**************");
				leaseController.activelease();
				System.out.println("******************************************");

			}
			else if (leasess == 4) {
				System.out.println("************LEASE HISTORY**************");
				LeaseController leaseController = new LeaseController();
				System.out.print("CUSTOMER ID-----------> ");
				int custom1 = scan.nextInt();
				leaseController.historyLease(custom1);
				System.out.println("******************************************");
			}

			else if (leasess == 0) {

				System.out.println("******************************************");
				break;
			} else {
				System.out.println("###########-->INVALID CHOOSE<--##################");

			}
		}
	}

}
