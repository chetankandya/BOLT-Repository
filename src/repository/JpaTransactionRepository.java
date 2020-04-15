package repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import entity.AccountDetails;
import entity.CustomerDetails;
import entity.TransactionDetails;
import exception.CustException;

public class JpaTransactionRepository implements TransactionRepository {

	@PersistenceContext(unitName = "SpringJPA")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addTransaction(TransactionDetails transaction) {
		System.out.println("Here");
		// CustomerDetails s = entityManager.find(CustomerDetails.class,custId);

		entityManager.persist(transaction);

		CustomerDetails s = entityManager.find(CustomerDetails.class, transaction.getCustId());
		// Set<TransactionDetails> td = new HashSet<TransactionDetails>();
		Set<TransactionDetails> td = s.getTransactionDetails();
		// if(td.)
		System.out.println(td.contains(transaction.getCustId()));

		td.add(transaction);

		s.setTransactionDetails(td);
		entityManager.persist(s);
		// System.out.println("Hi345");
		// System.out.println("transaction"+transaction);

	}
	//
	// @Override
	// @Transactional
	// public TransactionDetails getTransaction(String transId)
	// {
	// System.out.println("getTransaction invoked");
	// TransactionDetails td=entityManager.find(TransactionDetails.class, transId);
	// return td;
	// }

	@Override
	@Transactional
	public Set<TransactionDetails> detailfromto(int customerid, Date from, Date to) {


		CustomerDetails s = entityManager.find(CustomerDetails.class, customerid);
		Set<TransactionDetails> td = s.getTransactionDetails();
		System.out.println("all"+td);
		Iterator<TransactionDetails> it = td.iterator();
		int day = 0;
		Set<TransactionDetails> td2 = new HashSet<TransactionDetails>();
		/*LocalDate currfrom = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate currto = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int currentfrom = currfrom.getMonthValue();
		int currentto = currto.getMonthValue();
		int datamonth = 0;int dayfrom=currfrom.getDayOfMonth();int dayto=currto.getDayOfMonth();
		int year=0;int yearfrom=currfrom.getYear();int yearto=currto.getYear();*/
		//int currdayfrom = currfrom.getMonthValue();
		
		// Enumeration e = Collections.enumeration(td);
		// System.out.println();

		while (it.hasNext()) {
			TransactionDetails td1 = it.next();
			 Date date=td1.getTransferDate();
			 System.out.println(date);
			
			
			 /* System.out.println(date+" "+from);
			  System.out.println(from.before(date));
			  LocalDate data =date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			  datamonth =data.getMonthValue();
			  day=data.getDayOfMonth(); 
			  year=data.getYear();
			  System.out.println("day"+day+"day from "+dayfrom+"day to "+dayto);
			  System.out.println("datamonth"+datamonth+"month from"+currentfrom+"month to"+currentto); 
			  System.out.println("datayear"+year+" yar from"+yearfrom+" year to"+yearto);
			  System.out.println(datamonth>=currentto &&
			  datamonth<=currentfrom);
			  System.out.println("from"+from+"to"+to);*/
			 /* if(year>=yearfrom && year<=yearto) {
				 
			  if(datamonth>=currentfrom &&
					  datamonth<=currentto) { 
				  if(day>=dayfrom && day<=dayto) {*/
			 System.out.println(date.compareTo(from)+" "+date.compareTo(to));
			 System.out.println("from "+from+" to "+to+" date "+date);
			 if(date.compareTo(from)>=0 && date.compareTo(to)>=0)
				  td2.add(td1);
				  
				  /*}}}*/
			 

			System.out.println(td1.getTransferDate());

		}
		System.out.println(td2);
		return td2;


	}

	@Override
	@Transactional
	public Set<TransactionDetails> detailBySixMonth(int customerid) {
		CustomerDetails s = entityManager.find(CustomerDetails.class, customerid);
		Set<TransactionDetails> td2 = new HashSet<TransactionDetails>();
		int datamonth = 0;
		Set<TransactionDetails> td = s.getTransactionDetails();
		Iterator<TransactionDetails> it = td.iterator();
		Date d = new Date();
		LocalDate currdate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int currentmonth = currdate.getMonthValue();
		while (it.hasNext()) {
			TransactionDetails td1 = it.next();
			Date date = td1.getTransferDate();
			LocalDate data = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			datamonth = data.getMonthValue();
			if ((datamonth <= currentmonth) && (datamonth >= currentmonth - 6)) {
				td2.add(td1);
			}

		}
		return td2;
	}

	@Override
	@Transactional
	public TransactionDetails getLastTransAmount(int customerid)  {
		CustomerDetails s = entityManager.find(CustomerDetails.class, customerid);
		//Set<TransactionDetails> td2 = new HashSet<TransactionDetails>();
		TransactionDetails td1=null;
		Set<TransactionDetails> td = s.getTransactionDetails();
		System.out.println("all"+td);
		Iterator<TransactionDetails> it = td.iterator();
		int max=0;
		while(it.hasNext()) {
		int datamonth = 0;

		 td1 = it.next();
		if(max<td1.getTransId()) 
			max=td1.getTransId();
		
		}
		TransactionDetails td2 = entityManager.find(TransactionDetails.class, max);
		System.out.println("last"+td2);
		return td2;
	}

	@Override
	@Transactional
	public void getLastTransDate(int customerid)  {
		// TODO Auto-generated method stub

	}

}
