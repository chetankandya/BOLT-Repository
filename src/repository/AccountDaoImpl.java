package repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import entity.AccountDetails;
import entity.BeneficiaryDetails;
import entity.CustomerDetails;
import entity.TransactionDetails;
import exception.CustException;

public class AccountDaoImpl implements AccountDao {

	@PersistenceContext(unitName = "SpringJPA")
	private EntityManager entityManager;

	public AccountDaoImpl() {
		System.out.println("AccountDaoImpl() ctor...");
	}

	@Override
	@Transactional
	public void openAccount(AccountDetails a)  {
		entityManager.persist(a);

	}

	@Override
	@Transactional
	public AccountDetails showAccount(int custId) {
		CustomerDetails s = entityManager.find(CustomerDetails.class, custId);
		int accno = s.getAccountDetails().getAccNo();
		AccountDetails ac = entityManager.find(AccountDetails.class, accno);

		return ac;
	}

	@Override
	@Transactional
	public AccountDetails getAccount(int custId)  {
		System.out.println("Here");

		CustomerDetails s = entityManager.find(CustomerDetails.class, custId);

		int accno;
		try {
			accno = s.getAccountDetails().getAccNo();
		} catch (Exception e) {

		
			return null;
		}

		String check = String.valueOf(accno);

		if (check != null) {
			AccountDetails ac = entityManager.find(AccountDetails.class, accno);
			return ac;
		} else

			return null;
	}

	@Override
	@Transactional
	public int doCredit(double amount, int custId, int accno) {


		AccountDetails ac = entityManager.find(AccountDetails.class, accno);

		try {
			double balance = ac.getBalance();

			balance += amount;

			System.out.println("beneficiary acc no" + accno);

			ac.setBalance(balance);

			entityManager.persist(ac);

			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	@Transactional
	public int doDebit(double amount, int custId, int accNo) {

		double amt = 200;
        
		AccountDetails incomingacc = entityManager.find(AccountDetails.class, accNo);
		
		if(incomingacc!=null)
		{
		CustomerDetails cd = entityManager.find(CustomerDetails.class, custId);
		int acc = cd.getAccountDetails().getAccNo();

		AccountDetails ac = entityManager.find(AccountDetails.class, acc);
		System.out.println(ac);

		// int accno=ac.getAccNo();
		// System.out.println(accno);

		double balance = ac.getBalance();
		System.out.println(balance);

		if ((balance >= amt) && (balance > amount)) {

			balance -= amount;

			ac.setBalance(balance);
			System.out.println(balance);

			entityManager.persist(ac);

			return 1;

		} else {
			System.out.println("insufficient balance");
			return 0;
		}
		}
		else
		{
			System.out.println("Account Number Doesn't Exists :");
			
			return 0;
		}

	}

	@Override
	@Transactional
	public int doDebit1(double amount, int customerid)  {

		int status = 0;

		double amt = 200;

		System.out.println(customerid + " " + amount);

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date d = new Date();

		CustomerDetails cd = entityManager.find(CustomerDetails.class, customerid);
		int acc = cd.getAccountDetails().getAccNo();

		AccountDetails ac = entityManager.find(AccountDetails.class, acc);
		System.out.println(ac);

		double balance = ac.getBalance();
		System.out.println(balance);

		if ((balance >= amt) && (balance > amount)) {
			balance -= amount;
			ac.setBalance(balance);
			System.out.println(balance);

			entityManager.persist(ac);

			status = 1;

		} else {
			System.out.println("insufficient balance");
			status = 0;

		}

		return status;
	}

	@Override
	@Transactional
	public int doCredit1(double amount, int customerid, BeneficiaryDetails bd) {

		System.out.println(customerid + " " + bd + " " + amount);
		// String c=custId;
		// BeneficiaryDetails bd=entityManager.find(BeneficiaryDetails.class,
		// ben.getBenAccNo());
		AccountDetails ac = entityManager.find(AccountDetails.class, bd.getBenAccNo());

		System.out.println(ac);
		double balance = ac.getBalance();
		balance += amount;
		System.out.println("beneficiary acc no" + bd.getBenAccNo());
		ac.setBalance(balance);

		return 1;

	}

}
