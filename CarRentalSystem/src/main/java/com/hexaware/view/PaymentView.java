package com.hexaware.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.hexaware.controller.PaymentController;
import com.hexaware.model.Payment;

public class PaymentView {
	Scanner scan =new Scanner(System.in);
	public void display() throws SQLException
	{
		PaymentController paymentController=new PaymentController();
		
		while(true)
		{
			System.out.println("***********************");
			System.out.println("PAYMENT HISTORY-------> 1");
			System.out.println("PAYMENT DETAIL--------> 2");
			System.out.println("EXIT------------------> 0");
			
			System.out.println("*********CHOOSE**********");
			System.out.print("Give the NO :----------->");
			int input=scan.nextInt();
			if (input==1)
			{
				paymentController.listPayment();;
				continue;
			}
			else if(input==2)
			{
				paymentController.printPayment();
				continue;
			}
			
			else if (input==0)
			{
				
				break;
			}
			else
			{
				System.out.println("###########-->INVALID CHOOSE<--##################");

			}
		}
	}
	

}
