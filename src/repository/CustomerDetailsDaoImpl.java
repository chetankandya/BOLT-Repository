package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.CustomerDetails;
import exception.CustException;

public class CustomerDetailsDaoImpl implements CustomerDetailsDao{

	@Override
	public CustomerDetails getCustomer(int custId) {
		return null;
	}

	@Override
	public void updateProfile(int custId, String custName, String mobileNo, String emailId, String gender,
			String aadharNo, String panNo, String dateOfBirth)  {
		// TODO Auto-generated method stub
		
	}


/*	
	@PersistenceContext(unitName="SpringJPA")
	private EntityManager entityManager;
	
	@Override
	public CustomerDetails getCustomer(String custId) {

		System.out.println("Entity manager : "+entityManager);
		
		System.out.println(CustomerDetails.class);
		CustomerDetails logObject = entityManager.find(CustomerDetails.class,custId);
		System.out.println(logObject);
		
		return logObject;
	}

	@Override
	public void updateProfile(String custId, String custName, String mobileNo, String emailId, String gender,
			String aadharNo, String panNo, String dateOfBirth) {
		// TODO Auto-generated method stub
		
	}
*/
}
