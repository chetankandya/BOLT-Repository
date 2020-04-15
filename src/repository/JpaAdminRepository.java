package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import entity.AccountDetails;
import entity.AdminDetails;
import entity.CustomerDetails;

public class JpaAdminRepository implements AdminRepository{

	@PersistenceContext(unitName="SpringJPA")
	private EntityManager entityManager;
//	
//	private JpaAdminRepository jpaAdminRepository;
//	
//	private AccountDetails accountdetails;
	
	
	
	@Override
	@Transactional
	public AdminDetails addAdmin(AdminDetails admin) {
		System.out.println("addAdmin()...");
		entityManager.persist(admin);
		return admin;
	}
	
	@Override
	@Transactional
	public AdminDetails getAdmin(String adminId) {
		System.out.println("getAdmin(String id) invoked...");
		AdminDetails  ad = entityManager.find(AdminDetails.class, adminId);	
		return ad;
	}
}
