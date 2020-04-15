package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import entity.*;
import repository.RegisterRepository;
import repository.TransactionRepository;

@Controller
public class TransactionController {

	@Autowired
	public TransactionRepository transactionRepository;
	
	@Autowired
	private RegisterRepository registerRepository;


	public TransactionController() {
		System.out.println("Transaction ctr");

	}

	@RequestMapping(value = "/transaction.do")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws Exception {
		ModelAndView mav = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date from = (java.util.Date) formatter.parse(req.getParameter("from_date"));
		Date to = (java.util.Date) formatter.parse(req.getParameter("to_date"));
		
		
		Login t = (Login) session.getAttribute("customerdetails");
		System.out.println("t is "+t);
		CustomerDetails custDetails = registerRepository.getCustomer(new Integer(t.getCustId()));
		System.out.println("cust id : "+custDetails.getCustId());

		Set<TransactionDetails> set = transactionRepository.detailfromto(custDetails.getCustId(), from, to);
		System.out.println(set != null);
		if (set != null) {
			View view = new InternalResourceView("showtransaction.jsp");
			mav = new ModelAndView(view);
			System.out.println(set);
			Iterator<TransactionDetails> it = set.iterator();
		
			
			mav.addObject("view", set);

		}
		System.out.println("register object filled up ..");
		return mav;

		
	}

	@RequestMapping(value = "/lastsix.do")
	public String lastsix(HttpServletRequest req, HttpServletResponse res, HttpSession session,Map<String, TransactionDetails>model)
			throws Exception {
		
		
		/*String customerid = (String) session.getAttribute("customerid");
		Set<TransactionDetails> set = transactionRepository.detailBySixMonth(customerid);
		System.out.println(set);*/
		
		Login t = (Login) session.getAttribute("customerdetails");
		Set<TransactionDetails> set = transactionRepository.detailBySixMonth(new Integer(t.getCustId()));
		System.out.println("t is "+t);
		
		CustomerDetails custDetails = registerRepository.getCustomer(new Integer(t.getCustId()));
		if (set != null) {
			/*View view = new InternalResourceView("showtransaction.jsp");
			mav = new ModelAndView(view);*/
			System.out.println(set);
			Iterator<TransactionDetails> it = set.iterator();
			int i=1;
			
			while(it.hasNext()) {
				String k=""+i;
				System.out.println(k);
			 TransactionDetails td1=it.next();
			 System.out.println(td1);
			
			 model.put("view".concat(k),td1);
			 i++;
			}
		}
		/* View view = new InternalResourceView("showtransaction.jsp");
		 ModelAndView mav = new ModelAndView(view);
			mav.addObject("view",set);*/
		return "showtransaction";
		
	}
	
	
	@RequestMapping(value = "/lasttransamount.do")
	public ModelAndView lasttransamount(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws Exception {
		
		Login t = (Login) session.getAttribute("customerdetails");
		System.out.println("t is "+t);
		CustomerDetails custDetails = registerRepository.getCustomer(new Integer(t.getCustId()));
		System.out.println("cust id : "+custDetails.getCustId());
		
		/*String customerid = (String) session.getAttribute("customerid");*/
		
		TransactionDetails td= transactionRepository.getLastTransAmount(custDetails.getCustId());
		System.out.println(td);
		
	 View view = new InternalResourceView("showlasttransaction.jsp");
	 ModelAndView mav = new ModelAndView(view);
		mav.addObject("transaction",td);
	return mav 	;
	}
}