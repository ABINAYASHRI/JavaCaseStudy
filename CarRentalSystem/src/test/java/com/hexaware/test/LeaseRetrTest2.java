/* * 
 * *This the Junit test cases implementation
 * *
 * */
package com.hexaware.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.ICarLeaseRepository;
import com.hexaware.dao.ICarLeaseRepositoryImpl;
import com.hexaware.model.*;

/*
 * Class to test the services of Car Renstal System*/
public class LeaseRetrTest2 {

    ICarLeaseRepository carLeaseRepo;
    Customer cus;
    //Executes befor Test Case
	 @Before
	    public void setUp() {
	        carLeaseRepo = new ICarLeaseRepositoryImpl();
	        
	    }
//Test for retrieval of Lease by lease id
    @Test
    public void testLeaseRetrieval() throws SQLException {
        Lease retrievedLease = carLeaseRepo.findLeaseById(7001);
        assertNotNull(retrievedLease);
////         assertEquals = (null,findLeaseById());
    }
    
   
// Test for Adding a new customer without redundancy
    @Test
    public void testAddCustomer_Successful() throws SQLException {
        ICarLeaseRepositoryImpl repository = new ICarLeaseRepositoryImpl();
        Customer customer = new Customer("Pooja", "R", "pooja@emails.com", "1234567890");
        assertTrue(repository.addCustomer(customer));
    }
// Test for checking the existing customer
    @Test
    public void testAddCustomer_CustomerAlreadyExists() throws SQLException {
        ICarLeaseRepositoryImpl repository = new ICarLeaseRepositoryImpl();
        Customer existingCustomer = new Customer("John", "Doe", "john@example.com", "1234567890");
        assertFalse(repository.addCustomer(existingCustomer));
    }
    
//	After every test cases this will run
    
    @After
	public void tearDown() {
		System.out.println("Tear Down called after the test case");
		carLeaseRepo=null;
	}
}


