package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import entity.AccountDetails;
import entity.AdminDetails;
import entity.AdminLogin;
import entity.CustomerDetails;


public class JpaAdminLoginRepository implements AdminLoginRepository {

	@PersistenceContext(unitName="SpringJPA")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void createLogin(AdminLogin x) {
		System.out.println("createAdminLogin()...");
		entityManager.persist(x);
		
	}

	@Override
	@Transactional
	public AdminLogin getLogin(AdminLogin x) {
	
        System.out.println("the object is :"+x.getAdminId());
		
		
		AdminDetails s = entityManager.find(AdminDetails.class, x.getAdminId());
	
		
		if(s.getPassword().equals(x.getPassword())) {
			return x;
		}
		else 
		{
			return null;
		}
	}

	@Override
	@Transactional
	public CustomerDetails viewCustomer(int custId) {
		CustomerDetails cd= entityManager.find(CustomerDetails.class, custId);
		return cd;
	}

	/*
	@Override
	@Transactional
	public AccountDetails viewAccount(String custId) {
		CustomerDetails s = entityManager.find(CustomerDetails.class,custId);
		int accno=s.getAccountDetails().getAccNo();
		AccountDetails ac=entityManager.find(AccountDetails.class, accno);
		return ac;
	}*/

	@Override
	@Transactional
	public List<CustomerDetails> viewAllCustomer() {
		
		System.out.println("here ");
		List<CustomerDetails> s=(List<CustomerDetails>)
		entityManager.createQuery("from CustomerDetails").getResultList();
		return s;
	}
	
	@Override
	@Transactional
	public AdminDetails setPermission(CustomerDetails cd) {
		// TODO Auto-generated method stub
		return null;
	}

}
