package repository;
import entity.*;
import exception.CustException;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface TransactionRepository {

	public void addTransaction(TransactionDetails Transaction);
//	public TransactionDetails getTransaction(String transId);
	public TransactionDetails getLastTransAmount(int customerid);
	public void getLastTransDate(int customerid);
	public Set<TransactionDetails> detailfromto(int customerid,Date from,Date to);
	public Set<TransactionDetails> detailBySixMonth(int customerid);
	//public List<TransactionDetails> detailByDate();
	
}
