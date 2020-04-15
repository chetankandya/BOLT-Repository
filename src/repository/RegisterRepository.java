package repository;

import java.util.List;

import entity.CustomerDetails;
import entity.Login;
import exception.CustException;

public interface RegisterRepository {
	
	CustomerDetails addCustomer(CustomerDetails customers)throws CustException;
	CustomerDetails getCustomer(int x)throws CustException;
	public void mergeCustomer(Object obj)throws CustException;
	public CustomerDetails updateProfile(int customerid,String custName, String mobileNo, String emailId,String dateOfBirth,String address,String city,String country,String pincode)throws CustException;
	
	
	// public void deleteCustomer(CustomerDetails customer);
	// public String getCustId();

}
