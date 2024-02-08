package com.hexaware.controller;

import java.sql.SQLException;

import com.hexaware.model.Lease;

public interface LeaseInterface {
	
	public void leases() throws SQLException;
	
	
	public void printlease(Lease lease);
	
	
	public void activelease()throws SQLException;
	
}
