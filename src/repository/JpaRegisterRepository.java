package repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entity.CustomerDetails;
import entity.Login;
import exception.CustException;


public class JpaRegisterRepository implements RegisterRepository{
	
	@PersistenceContext(unitName="SpringJPA")
	private EntityManager entityManager;

	@Override
	@Transactional
	public CustomerDetails addCustomer(CustomerDetails customers) throws CustException {
		System.out.println("addCustomer()...");
		entityManager.persist(customers);
		return customers;
	}

	
	@Override
	@Transactional
	public void mergeCustomer(Object obj) throws CustException {
		System.out.println("mergeCustomer()...");
		entityManager.merge(obj);
		
	}

	@Override
	@Transactional
	public CustomerDetails getCustomer(int customerId) throws CustException {
		// TODO Auto-generated method stub
		System.out.println("getCustomer(String id) invoked...");
		CustomerDetails  cd = entityManager.find(CustomerDetails.class, customerId);
		if(cd!=null) {
		return cd;
	}else {
		return null;
	}
		}


	@Override
	@Transactional
	public CustomerDetails updateProfile(int customerid,String custName, String mobileNo, String emailId,String dateOfBirth,String address,String city,String country,String pincode) throws CustException {
		
		
		
		
		CustomerDetails  cd = entityManager.find(CustomerDetails.class,customerid);
		
		
		cd.setCustName(custName);
		cd.setMobileNo(mobileNo);
		cd.setEmailId(emailId);
		cd.setDateOfBirth(dateOfBirth);
		cd.setAddress(address);
		cd.setCity(city);
		cd.setCountry(country);
		cd.setPincode(pincode);
		entityManager.persist(cd);
		return cd;
		
		
	}
	

}
