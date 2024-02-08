package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Car;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;
import com.hexaware.model.Payment;
import com.hexaware.util.DBConnection;

public class ICarLeaseRepositoryImpl implements ICarLeaseRepository {
	// *****************CUSTOMER DETAIL******************************************//

	// ####################--->ADD CUSTOMER<--##########################//
	
	Car car = new Car();
	public boolean addCustomer(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;		
		boolean success = false;
		try {
			con = DBConnection.getConnection();
			
			String query = "SELECT COUNT(*) FROM Customer WHERE email = ?";
	        pstmt = con.prepareStatement(query);
	        pstmt.setString(1, customer.getEmail());
	        resultSet = pstmt.executeQuery();
			
	        if (resultSet.next() && resultSet.getInt(1) == 0) {
			
			query = "INSERT INTO Customer (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, customer.getfName());
			pstmt.setString(2, customer.getlName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPhoneNo());
			int qryResult = pstmt.executeUpdate();
			if (qryResult == 1) {
				System.out.println("New User data inserted");
				success = true;
			} else {
				System.out.println("Something went wrong on inserting new user");
			}} else {
	            System.out.println("Customer with the same email already exists");
	        }
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return success;
	}
	
	private boolean customerExists(Connection con, Customer customer) throws SQLException {
	    PreparedStatement pstmt = null;
	    ResultSet resultSet = null;
	    try {
	        String query = "SELECT * FROM Customer WHERE email = ?";
	        pstmt = con.prepareStatement(query);
	        pstmt.setString(1, customer.getEmail());
	        resultSet = pstmt.executeQuery();
	        return resultSet.next(); // Returns true if customer exists, false otherwise
	    } finally {
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (resultSet != null) {
	            resultSet.close();
	        }
	    }
	}
	
//	for Junit testing

	public boolean addCustomerbool(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		try {
			con = DBConnection.getConnection();
			String query = "INSERT INTO Customer (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, customer.getfName());
			pstmt.setString(2, customer.getlName());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPhoneNo());
			int qryResult = pstmt.executeUpdate();
			if (qryResult == 1) {
				System.out.println("New User data inserted");
				success = true;
			} else {
				System.out.println("Something went wrong on inserting new user");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return success;
	}

	// ####################--->FIND CUSTOMER BY ID <--##########################//
	
	public Customer findCustomerById(int customerID) throws SQLException {
		Customer customer = new Customer();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			con = DBConnection.getConnection();
			String query = " SELECT * FROM Customer WHERE customerID = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, customerID);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				System.out.println("Customer found");
				Customer cst = new Customer();
				cst.setCustomerDetails(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5));
				System.out.println(cst.getId());
				System.out.println(cst.getfName());
				System.out.println(cst.getlName());
				System.out.println(cst.getEmail());
				System.out.println(cst.getPhoneNo());

			} else {
				System.out.println("Customer Not Found");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return customer;
	}
	
	
	
	
	

	
	// ####################--->FIND CUSTOMER EMAI ID<--##########################//

	
	public Customer findCustomerByEmailid(Customer customer) throws SQLException {
		
		System.out.println("Processing.....");	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			con = DBConnection.getConnection();
			String query = "SELECT * FROM Customer WHERE email = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,customer.getEmail());
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				System.out.println("Customer found");
				System.out.println(rSet.getString(4));
				customer.setAuthentication(true);
				Customer cst = new Customer();
				cst.setCustomerDetails(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5));
//				System.out.println(cst.getId());
//				System.out.println(cst.getfName());
//				System.out.println(cst.getlName());
//				System.out.println(cst.getEmail());
//				System.out.println(cst.getPhoneNo());
//				
			

			} else {
				System.out.println("Customer Not Found");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return customer;
	}
	
	


	public String findCByEmailid(String id)throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		String email = null;
		try {
			con = DBConnection.getConnection();
			String query = "SELECT * FROM Customer WHERE email = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,customer.getEmail());
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				System.out.println("Customer found");
				System.out.println(rSet.getString(4));
				customer.setAuthentication(true);
				Customer cst = new Customer();
				cst.setCustomerDetails(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5));
//				System.out.println(cst.getId());
//				System.out.println(cst.getfName());
//				System.out.println(cst.getlName());
//				System.out.println(cst.getEmail());
//				System.out.println(cst.getPhoneNo());
//			
				email = cst.getEmail();
				if (email == id){return email;}
				

			} else {
				System.out.println("Customer Not Found");
			}
		
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		;
		return null;
		

	}
	
	
	//******************FINDCUSTOMER*****************
	
	public Customer findCustomer(Customer customer) throws SQLException {
		//Customer customer = new Customer();
		System.out.println("Successfully runned");	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			con = DBConnection.getConnection();
			String query = "SELECT * FROM Customer WHERE customerId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,customer.getId());
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				System.out.println("Customer found");
				System.out.println(rSet.getString(4));
				customer.setAuth(true);
				
			

			} else {
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return customer;
	}

	// ####################--->LIST CUSTOMER<--##########################//
	
	public List<Customer> listCustomers() throws SQLException {
		List<Customer> lsCust = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			con = DBConnection.getConnection();
			String query = " SELECT * FROM Customer ";
			pstmt = con.prepareStatement(query);
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				Customer cst = new Customer();
				cst.setCustomerDetails(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5));
				lsCust.add(cst);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return lsCust;
	}
	
	
	//###############################PAYMENT#########################//
	
	
	
	

	// ####################--->REMOVE CAR<--##########################//

	public void removeCustomer(int customerID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConnection();
			String query = "DELETE from Customer WHERE customerID = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, customerID);
			int qryResult = pstmt.executeUpdate();
			if (qryResult == 1) {
				System.out.println("Customer Removed");
			} else {
				System.out.println("Customer Not Found");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	// *************************************************CAR DETAIL**********************************************************//

	// ####################--->ADD NEW CAR <--##########################//
	
	public void addCar(Car car) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConnection();
			String query = "INSERT INTO Vehicle (make, model, year, dailyRate, status, passengerCapacity, engineCapacity) VALUES (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, car.getMake());
			pstmt.setString(2, car.getModel());
			pstmt.setInt(3, car.getYear());
			pstmt.setDouble(4, car.getDailyRate());
			pstmt.setString(5, car.getStatus());
			pstmt.setInt(6, car.getPassCap());
			pstmt.setInt(7, car.getEngCap());
			int qryResult = pstmt.executeUpdate();
			if (qryResult == 1) {
				System.out.println("New Car data inserted");
			} else {
				System.out.println("Something went wrong on inserting new Car");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	// ####################--->FIND CAR BY ID <--##########################//
	
	public Car findCarById(int carID) throws SQLException {
		Car car = new Car();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			con = DBConnection.getConnection();
			String query = " SELECT * FROM Vehicle WHERE vehicleID = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, carID);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				System.out.println("Car found");
				
				car.setAuthenticate(true);
			} else {
				System.out.println("Car Not Found");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return car;
	}

	// ####################--->REMOVE CAR <--##########################//
	
	public void removeCar(int carID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConnection();
			String query = "DELETE from vehicle WHERE vehicleId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, carID);
			int qryResult = pstmt.executeUpdate();
			if (qryResult == 1) {
				System.out.println("Car Removed");
			} else {
				System.out.println("Car Not Found");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	// ####################--->LIST AVAILABLE CARS <--##########################//
	
	public List<Car> listAvailableCars() throws SQLException {
		List<Car> lscar = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			con = DBConnection.getConnection();
			String query = " SELECT * FROM Vehicle WHERE status = 'available'";
			pstmt = con.prepareStatement(query);
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				Car cr = new Car();
				cr.setCarDetails(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getInt(4),
						rSet.getDouble(5), rSet.getString(6), rSet.getInt(7), rSet.getInt(8));
				lscar.add(cr);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return lscar;
	}
	
	


	// ####################--->LIST RENTED CARS <--##########################//
	
	public List<Car> listRentedCars() throws SQLException {
		List<Car> lscar = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			con = DBConnection.getConnection();
			String query = " SELECT * FROM Vehicle WHERE status != 'available'";
			pstmt = con.prepareStatement(query);
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				Car cr = new Car();
				cr.setCarDetails(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getInt(4),
						rSet.getDouble(5), rSet.getString(6), rSet.getInt(7), rSet.getInt(8));
				lscar.add(cr);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return lscar;
	}
	// ####################--->FIND CAR<--##########################//

	
	
		public Car findCar(Car car) throws SQLException {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rSet = null;
			try {
				con = DBConnection.getConnection();
				String query = " SELECT * FROM Vehicle WHERE status = 'available' && vehicleID=? ";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, car.getId());
				rSet = pstmt.executeQuery();
				if (rSet.next()) {
					System.out.println("Car found");
					car.setAuthenticate(true);
				} else {
					System.out.println("Car Not Found");
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			}
			return car;
		}
//######################### UPDATE CAR ###############################
			public void UpdateCar(int vehicleID) throws SQLException {
				
				Connection con = null;
				PreparedStatement pstmt = null;
				
				try {
					con = DBConnection.getConnection();
					String query = " UPDATE Vehicle SET status='Rented' WHERE status='available' AND vehicleID=?";
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, vehicleID);
					int qryResult = pstmt.executeUpdate();  

					if (qryResult >0) {
						System.out.println("Car RENTED");
						
					} else {
						System.out.println("Car NOT RENTED");
					}
				} catch (Exception e) {
					System.out.println("CAR NOT AVAILABLE");
				} finally {
					if (con != null) {
						con.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
				}
			}
	// *************************************************LEASE DETAIL**********************************************************//
	// ####################--->CREATE NEW LEASE<--##########################//
	
	public void createLease(Lease lease) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConnection();
			String query = "INSERT INTO Lease (vehicleID, customerID, startDate,endDate,type) VALUES (?,?,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, lease.getVehicleId());
			pstmt.setInt(2, lease.getCustId());
			pstmt.setString(3, lease.getStartDate());
			pstmt.setString(4, lease.getEndDate());
			pstmt.setString(5, lease.getType());
			int qryResult = pstmt.executeUpdate();
			if (qryResult == 1) {
				System.out.println("Lease registered");
				
			} else {
				System.out.println("Something went wrong on registering lease");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong on registering lease");
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	// ####################--->FIND LEASES BY ID <--##########################//
	// ####################--->FIND LEASES BY ID <--##########################//
		public Lease findLeaseById(int leaseId) throws SQLException {
			Lease lease = new Lease();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rSet = null;
			try {
				con = DBConnection.getConnection();
				String query = " SELECT * FROM Lease WHERE leaseID = ?";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, leaseId);
				rSet = pstmt.executeQuery();
				if (rSet.next()) {
					
					System.out.println("Lease found");
					lease.setAuth(true);
				}}
//				} else {
//					System.out.println("Lease Not Found");
//				}
			 catch (Exception e) {
				System.out.println(e);
			} finally {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			}
			return lease;
		}
	
	public Lease findLease(int leaseId) throws SQLException {
		Lease lease = new Lease();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			con = DBConnection.getConnection();
			String query = " SELECT * FROM Lease WHERE leaseID = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, leaseId);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				System.out.println("Lease found");
				System.out.println("lease ID :--->" + rSet.getInt(1));
				System.out.println("VehicleID:--->" + rSet.getInt(2));
				System.out.println("custId:------>" + rSet.getInt(3));
				System.out.println("startDate:--->" + rSet.getString(4));
				System.out.println("endDate:s :-->" + rSet.getString(5));
				System.out.println("type:s :----->" + rSet.getString(6));
				System.out.println("----------------------------------\n");
			} else {
				System.out.println("Lease Not Found");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return lease;
	}
	
	
	// ####################--->FIND LEASES ID <--##########################//
		public Lease findLeaseId(int vehicle) throws SQLException {
			Lease lease = new Lease();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rSet = null;
			try {
				con = DBConnection.getConnection();
				String query = " SELECT * FROM Lease WHERE vehicleID = ?";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, vehicle);
				rSet = pstmt.executeQuery();
				if (rSet.next()) {
					int v=rSet.getInt(1);
					lease.setId(v);
					System.out.println(rSet.getInt(1));
				} else {
					System.out.println("Lease Not Found");
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			}
			return lease;
		}
		
		
		
		
		
//	********************HISTORY LEASES***********************************************
	public List<Lease> historyLease(int customerID) throws SQLException {
		List<Lease> les1 = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		
		try {
			con = DBConnection.getConnection();
			String query = " SELECT * FROM Lease WHERE customerID = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, customerID);
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				Lease les = new Lease();
				les.setLeaseDetails(rSet.getInt(1), rSet.getInt(2), rSet.getInt(3), rSet.getString(4),
						rSet.getString(5), rSet.getString(6));
				les1.add(les);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return les1;
	}

	
	
	
	

	// ####################--->LIST ACTIVE LEASES <--##########################//

	public List<Lease> listActiveLeases() throws SQLException {
		List<Lease> lesList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			con = DBConnection.getConnection();
			String query = " SELECT * FROM Lease ";
			pstmt = con.prepareStatement(query);
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				Lease les = new Lease();
				les.setLeaseDetails(rSet.getInt(1), rSet.getInt(2), rSet.getInt(3), rSet.getString(4),
						rSet.getString(5),rSet.getString(6));
				lesList.add(les);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return lesList;
	}
	// *************************************************PAYMENTDETAIL**********************************************************//

	

	

		@Override
		public double addpayment(int vehicle) throws SQLException {
			// TODO Auto-generated method stub
			
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rSet = null;
				double v= 0;
				try {
					con = DBConnection.getConnection();
					String query = " SELECT * FROM Vehicle WHERE vehicleID = ? ";
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, vehicle);
					rSet = pstmt.executeQuery();
					if (rSet.next()) {
						System.out.println("Customer found");
						Lease car1=new Lease();
						
						car1.setAmount(rSet.getDouble(5));
						v=car1.getAmount();
					} else {
						System.out.println("Customer Not Found");
					}
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					if (con != null) {
						con.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
				}
			
			return v;
		}
		
//		###################### Lease Id########################
		public int leaseId(int vehicle) throws SQLException {
			// TODO Auto-generated method stub
			
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rSet = null;
				int v= 0;
				try {
					con = DBConnection.getConnection();
					String query = " SELECT * FROM Lease WHERE vehicleID = ? ";
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, vehicle);
					rSet = pstmt.executeQuery();
					if (rSet.next()) {
						System.out.println("Lease Found");
						Lease car1=new Lease();
						car1.setId(rSet.getInt(1));
						v=car1.getId();
						
					} else {
						System.out.println("Customer Not Found");
					}
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					if (con != null) {
						con.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
				}
			
			return v;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		##################################Payment ID################################//
		
		public void Paymentid(int leaseID) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rSet = null;
			try {
				con = DBConnection.getConnection();
				String query = " SELECT * FROM Payment WHERE leaseID = ?";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, leaseID);
				rSet = pstmt.executeQuery();
				if (rSet.next()) {
					System.out.println("Payment");
					Payment cst = new Payment();
					
					System.out.println("PaymentID-->"+rSet.getInt(1));
					System.out.println("LeaseID---->"+rSet.getInt(2));
					System.out.println("PayDate---->"+rSet.getString(3));
					System.out.println("Amount----->"+rSet.getDouble(4));
					

				} else {
					System.out.println("Customer Not Found");
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			}
			
		}
		// ####################--->RECORDPAYMENT<--##########################//

		public void recordPayment(Lease lease,Payment pay) throws SQLException  {
			Connection con = null;
			PreparedStatement pstmt = null;
	 		
			try {
				con = DBConnection.getConnection();
				String query = "INSERT INTO Payment (leaseID, amount) VALUES (?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, pay.getLeaseId());
				pstmt.setDouble(2, pay.getAmount());
				int qryResult = pstmt.executeUpdate();
				if (qryResult == 1) {
					System.out.println("Payment Successful");
				} else {
					System.out.println("Something went wrong on Transaction");
				}
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Something went wrong on Transaction");
			} finally {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			}
		}
		public List<Payment> listPayment() throws SQLException {
			List<Payment> Pl = new ArrayList<>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rSet = null;
			try {
				con = DBConnection.getConnection();
				String query = " SELECT * FROM Payment WHERE leaseID ";
				pstmt = con.prepareStatement(query);
				rSet = pstmt.executeQuery();
				while (rSet.next()) {
					Payment cst = new Payment();
					cst.setPayment(rSet.getInt(1));
					cst.setPayment(rSet.getInt(2),rSet .getDouble(4));
					cst.setPayDate(rSet.getString(3));
					Pl.add(cst);
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			}
			return Pl;
		}

		
		
		
		
		
	
}
