package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import entity.AccountDetails;
import entity.BeneficiaryDetails;
import entity.CustomerDetails;
import entity.IfscCode;
import entity.Login;
import entity.TransactionDetails;
import exception.CustException;
import repository.AccountDao;
import repository.LoginRepository;
import repository.RegisterRepository;
import repository.TransactionRepository;

@Controller
public class AccountController {

	@Autowired
	private AccountDao accountRepository;
	@Autowired
	public TransactionRepository transactionRepository;

	@Autowired
	private RegisterRepository registerRepository;

	@PersistenceContext(unitName = "SpringJPA")
	private EntityManager entityManager;

	public AccountController() {
		System.out.println("AccountController() ctor...");
	}

	@RequestMapping(value = "/account.do", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws Exception {

		Login t = (Login) session.getAttribute("customerdetails");
		System.out.println("t is " + t);

		System.out.println("Customer Id " + t.getCustId());

		ModelAndView mav = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String customerid = (String) session.getAttribute("customerid");
		
		String branch = req.getParameter("branch");
		String balance = req.getParameter("balance");
		String accounttype = req.getParameter("accounttype");
		java.util.Date dateOfOpening = (java.util.Date) formatter.parse(req.getParameter("date"));

		CustomerDetails custDetails = registerRepository.getCustomer(new Integer(t.getCustId()));
		System.out.println("cust id : " + custDetails.getCustId());

		
		AccountDetails a = new AccountDetails();
		
		a.setBranch(branch);
		a.setBalance(Double.parseDouble(balance));
		a.setDateOfOpening(dateOfOpening);

		
		CustomerDetails c = new CustomerDetails();
		c.setCustId(custDetails.getCustId());
		a.setCustDetails(c);
		// a.setIfscCode(ifsc);
		a.setAcctype(accounttype);

		
		accountRepository.openAccount(a);
		
		
		View view = new InternalResourceView("accountCreated.jsp");
		mav = new ModelAndView(view);
		AccountDetails ad = accountRepository.getAccount(t.getCustId());
		session.setAttribute("ad", ad);

		mav.addObject("balance", ad.getBalance());
		System.out.println("message is added to mav");
		return mav;

	}

	@RequestMapping(value="/debit.do",method=RequestMethod.POST)
	public ModelAndView debit(HttpServletRequest req, HttpServletResponse res,HttpSession session) throws Exception {
		
		ModelAndView mav = null;
		try {
			Login t = (Login) session.getAttribute("customerdetails");
			System.out.println("t is "+t);
			CustomerDetails custDetails = registerRepository.getCustomer(t.getCustId());
			System.out.println("cust id : "+custDetails.getCustId()); 
			
			
			
			double amount=Double.parseDouble(req.getParameter("amount"));
			String customerid=	(String) session.getAttribute("customerid");
			int benaccno1=Integer.parseInt(req.getParameter("benAccNo"));
			String benName=req.getParameter("benName");
			
			
			
			int status=accountRepository.doDebit(amount,custDetails.getCustId(),benaccno1);
			
			int status1=0;
			
			
			
			if(status==1) {
				
				System.out.println("amount debited successfully");
				
				status1=accountRepository.doCredit(amount,custDetails.getCustId(),benaccno1);
				
				System.out.println("amount creditd succesfully");

			}
			
			else {
				
				System.out.println("Account Dosen't Exist");
				View view = new InternalResourceView("errorpage.jsp");
				mav = new ModelAndView(view);
				mav.addObject("message", "Account Doesn't Exist");
				return mav;
			}
			
			if(status==1 && status1==1) {
				
				TransactionDetails td=new TransactionDetails();
				
				td.setAmount(amount);
				
				td.setBenAccNo(benaccno1);
				
				td.setBenName(benName);
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
				java.util.Date date = new  java.util.Date();  
			    System.out.println(formatter.format(date)); 
				td.setTransferDate(date);
				
				td.setCustId(custDetails.getCustId());

				
				transactionRepository.addTransaction(td);
				
			}
			View view = new InternalResourceView("userhome.jsp");
			mav = new ModelAndView(view);
			
			return mav;
		} 
		
		
		catch (Exception e) 		
		{
			View view = new InternalResourceView("errorpage.jsp");
			mav = new ModelAndView(view);
			mav.addObject("message", "Invalid Credentials. Try Again...");
			return mav;
		}
	}

	@RequestMapping(value = "/show.do")
	public ModelAndView show(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		ModelAndView mav = null;
	
		Login t = (Login) session.getAttribute("customerdetails");
		System.out.println("t is " + t);
		CustomerDetails custDetails = registerRepository.getCustomer(new Integer(t.getCustId()));
		System.out.println("cust id : " + custDetails.getCustId());

		AccountDetails ac = accountRepository.showAccount(custDetails.getCustId());

		System.out.println(ac);
		if (ac != null) {
			View view = new InternalResourceView("showaccount.jsp");
			mav = new ModelAndView(view);
			mav.addObject("account", ac);
		}
		return mav;
	}

	@RequestMapping(value = "/debit1.do", method = RequestMethod.POST)
	public String debit1(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

		try {
			Login t = (Login) session.getAttribute("customerdetails");

			System.out.println("t is " + t);

			CustomerDetails custDetails = registerRepository.getCustomer(t.getCustId());
			System.out.println("cust id : " + custDetails.getCustId());

			double amount = Double.parseDouble(req.getParameter("amount"));
			int benaccno1 = Integer.parseInt(req.getParameter("benAccNo"));
			String benName = req.getParameter("benName");
			String ifsc = req.getParameter("ifscCode");

			BeneficiaryDetails bd = new BeneficiaryDetails();
			bd.setBenAccNo(benaccno1);
			bd.setBenIfsc(ifsc);
			bd.setBenName(benName);
			System.out.println(benaccno1);

			Set<BeneficiaryDetails> list = custDetails.getBeneficiaryDetails();

			System.out.println(list);

			Iterator<BeneficiaryDetails> itr = list.iterator();
			int status2 = 0;

			while (itr.hasNext()) {

				BeneficiaryDetails bd1 = itr.next();

				if (bd1.getBenAccNo() == benaccno1 && bd1.getBenIfsc().equals(ifsc)) {
					int status = accountRepository.doDebit1(amount, custDetails.getCustId());

					int status1 = 0;
					System.out.println(status);
					if (status == 1) {
						System.out.println("amount debited successfully");
						// status1=accountRepository.doCredit1(amount,custDetails.getCustId(),bd);
						System.out.println("amount creditd succesfully");

					} else {
						System.out.println("error");
					   }

					if (status == 1 && status1 == 0) {

						TransactionDetails td = new TransactionDetails();

						td.setAmount(amount);
						td.setBenAccNo(benaccno1);
						td.setBenName(benName);
						td.setCustId(custDetails.getCustId());

						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						java.util.Date date = new java.util.Date();
						System.out.println(formatter.format(date));

						td.setTransferDate(date);

						System.out.println("i am here");

						System.out.println(td.getBenAccNo());
						System.out.println(td.getBenName());
						System.out.println(td.getAmount());
						System.out.println(td.getCustId());

						transactionRepository.addTransaction(td);

						

						status2 = 1;
						System.out.println(status2);
					}
				}

				else {
					System.out.println("Beneficiary dosen't exist,Please add beneficiary first:");
					status2 = 0;
				}

			}

			if (status2 == 1) {
				return "userhome";
			} 
			else {
				return "addbeneficiary";
			}
		} 
		
		
		catch (Exception e) {
			return	"errorpage";		
		}
		
	
	}

}
