package repository;

import java.util.List;

import entity.AccountDetails;
import entity.BeneficiaryDetails;
import exception.CustException;

public interface AccountDao {

	public void openAccount(AccountDetails a) ;
	public AccountDetails showAccount(int custId);
	public int doCredit(double amount , int custId , int accno);
	public int doDebit(double amount , int custId , int accNo);
	public AccountDetails getAccount(int custId);
	public int  doDebit1(double amount,int customerid);
	public int  doCredit1(double amount,int customerid,BeneficiaryDetails bd);
	//public int showTransaction( amount , String custId , int accNo);
}
