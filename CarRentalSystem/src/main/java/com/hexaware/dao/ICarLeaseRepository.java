package com.hexaware.dao;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.model.Car;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;
import com.hexaware.model.Payment;

public interface ICarLeaseRepository {
	//Car function
	void addCar(Car car) throws SQLException;
	void removeCar(int carID) throws SQLException;
	List<Car> listAvailableCars() throws SQLException;
	List<Car> listRentedCars()throws SQLException;
	Car findCarById(int carID) throws SQLException;
	public Car findCar(Car car)throws SQLException;
	public void UpdateCar(int vehicleID) throws SQLException;
	
	//Customer function
	boolean addCustomer(Customer customer) throws SQLException;
	boolean addCustomerbool(Customer customer) throws SQLException;
	void removeCustomer(int customerID) throws SQLException;
	List<Customer> listCustomers() throws SQLException;
	Customer findCustomerById(int customerID) throws SQLException;
	Customer findCustomerByEmailid(Customer customer) throws SQLException;
	Customer findCustomer(Customer customer) throws SQLException;

	
	// lease fuction
	void createLease(Lease lease) throws SQLException;
	Lease findLeaseById(int leaseId) throws SQLException;
	List<Lease> listActiveLeases() throws SQLException;
	public double addpayment(int vehicle) throws SQLException;
	public Lease findLease(int leaseId) throws SQLException;


//	listLeaseHistory()
	public List<Lease> historyLease(int customerID) throws SQLException;
	public Lease findLeaseId(int customer) throws SQLException;
	public int leaseId(int vehicle) throws SQLException;
	

	//Payment
	public void recordPayment(Lease lease,Payment pay) throws SQLException;
	public List<Payment> listPayment() throws SQLException;
	String findCByEmailid(String id) throws SQLException;
}
