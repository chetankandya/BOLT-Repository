package repository;

import java.util.List;

import entity.AccountDetails;
import entity.AdminDetails;
import entity.CustomerDetails;

public interface AdminRepository {
	
	AdminDetails addAdmin(AdminDetails admin);
	AdminDetails getAdmin(String x);
}
