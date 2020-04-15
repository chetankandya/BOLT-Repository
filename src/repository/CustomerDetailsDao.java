package repository;

import entity.CustomerDetails;
import exception.CustException;

public interface CustomerDetailsDao {

	
	public CustomerDetails getCustomer(int custId);
	public void updateProfile(int custId, String custName, String mobileNo, String emailId,String gender,String aadharNo,String panNo,String dateOfBirth);
	// public void deleteCustomer(CustomerDetails customer);
	// public String getCustId();
}
