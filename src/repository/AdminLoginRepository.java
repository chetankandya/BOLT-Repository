package repository;

import java.util.List;

import entity.AccountDetails;
import entity.AdminDetails;
import entity.AdminLogin;
import entity.CustomerDetails;

public interface AdminLoginRepository {

	void createLogin(AdminLogin x);
	AdminLogin getLogin(AdminLogin x);
	CustomerDetails viewCustomer(int custId);
	//AccountDetails viewAccount(String custId);
	//List<CustomerDetails> viewAllCustomer(CustomerDetails x);
	List<CustomerDetails> viewAllCustomer();
	AdminDetails setPermission(CustomerDetails cd);
}
