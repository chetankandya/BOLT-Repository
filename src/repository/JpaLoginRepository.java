package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import entity.*;
import exception.CustException;

//Spring's direct support for JSR standard annotations for JPA
//is the best approach for accessing the EntityManager
//Similar to HibernateSupport classes, we also have JpaTemplate
//and JpaDaoSupport class as well, but not used widely though
public class JpaLoginRepository implements LoginRepository {

	@PersistenceContext(unitName="SpringJPA")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void createLogin(Login x)  {
		System.out.println("createLogin()...");
		entityManager.persist(x);
	}

	@Override
	@Transactional
	public Login getLogin(Login x)  {
		
		System.out.println("the object is :"+x.getCustId());
		
		
		CustomerDetails s = entityManager.find(CustomerDetails.class, x.getCustId());
	
		if(s!=null) 
			{
				if(s.getPassword().equals(x.getPassword())) {
					return x;
			}
				else 
				{
					return null;
				}
			}
		else 
		{
			return null;
		}
	
	}

	@Override
	@Transactional
	public List<Login> getAllLogins()  {
		
		return null;
	}

	@Override
	@Transactional
	public Login updateLogin(Login x) 
	{
		
       	CustomerDetails s = entityManager.find(CustomerDetails.class, x.getCustId());
       	
		try {
			if(s.getCustId()==(x.getCustId())) {
				
				if(s.getAadharNo().equals(x.getAadharNo()) && s.getPanNo().equals(x.getPanNo()))
				{
				   return x;		
				}
				else 
				{
				System.out.println("customer id not found");
				return null;
				}
			}
			
			else 
			{
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public void deleteLogin(Login x)  {
		// TODO Auto-generated method stub
		
	}
	@Override
	@Transactional
	public Login resetLogin(Login x)  
	{
		
       	CustomerDetails s = entityManager.find(CustomerDetails.class, x.getCustId());
       	
       	String newpass=x.getPassword();
       	s.setPassword(newpass);
       	System.out.println(s.getPassword());
		if(s.getCustId()==(x.getCustId())) {
			
			entityManager.persist(s);
		}
		else {
			return null;
		}
		return x;
	}
	
	
}
