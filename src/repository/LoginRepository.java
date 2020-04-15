package repository;

import java.util.List;

import entity.Login;
import exception.CustException;

public interface LoginRepository {
	void createLogin(Login x);
	Login getLogin(Login x) ;
	List<Login> getAllLogins() ;
	Login updateLogin(Login x) ;
	Login resetLogin(Login x) ;
	void deleteLogin(Login x) ;
	
}
