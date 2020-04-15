package controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;



import entity.*;
import repository.*;

@Controller

public class BeneficiaryController {

	@Autowired
	private BeneficiaryDetailsRepository beneficiaryDetailsRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
										 

	@RequestMapping("/addBeneficiary.do")
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res,HttpSession session) throws Exception {
		ModelAndView mav = null;
		
		try {
			Login t = (Login) session.getAttribute("customerdetails");
			System.out.println("t is "+t);
			
			System.out.println("Customer Id"+t.getCustId());
			
			String benAccNo = req.getParameter("benAccNo");
			System.out.println("Beneficiary Account No :  " + benAccNo);
			String benName = req.getParameter("benName");
			System.out.println("benName :  " + benName);
			String benPhone = req.getParameter("benPhone");
			System.out.println("benPhone :  " + benPhone);
			String benBank = req.getParameter("benBank");
			System.out.println("benBank :  " + benBank);
			String benIfsc = req.getParameter("benIfsc");
			System.out.println("benIfsc :  " + benIfsc);
			String benDesc = req.getParameter("benDesc");
			System.out.println("benDesc :  " + benDesc);

			int benAccountNumber=Integer.parseInt(benAccNo); 
			
			System.out.println("registerRepository : "+registerRepository);
			CustomerDetails custDetails = registerRepository.getCustomer(new Integer(t.getCustId()));
			System.out.println("cust id : "+custDetails.getCustId()); 
			
			Set<BeneficiaryDetails>benList = custDetails.getBeneficiaryDetails(); 
			
			if(benList.size()>0)
			{
				Iterator<BeneficiaryDetails> benIter= benList.iterator(); 
			
				boolean found=false;
				BeneficiaryDetails bt = null;
				
				while(benIter.hasNext()) 
				{
					bt = benIter.next(); 
					System.out.println("BT : "+bt);
						if(bt.getBenAccNo()==(benAccountNumber)) 
						{
							System.out.println("beneficiery found "+bt);
							System.out.println("bt "+bt.getBenAccNo());
							found=true;
							break;
						}
						else {
							System.out.println("existing beneficiery : ==> "+bt); 
							System.out.println("bt "+bt.getBenAccNo());
						}
				}
				
				if(found==true) {
					System.out.println("beneficiary already present");
				}
				else {
			
			    //custDetails.setCustId(t.getCustId());//101
				BeneficiaryDetails beneficiary = beneficiaryDetailsRepository.getBeneficiary(benAccountNumber); 
			
				if(beneficiary!=null) {
				
				custDetails.getBeneficiaryDetails().add(beneficiary);
				registerRepository.mergeCustomer(custDetails);
			
			
			    System.out.println("beneficiary 1 is created...");
				 
				System.out.println("Stored the log on the logRepository");
				View view = new InternalResourceView("fundtransfer.jsp");
				mav = new ModelAndView(view);
				System.out.println("view is added to mav");
				mav.addObject("message", "Customer details added Successfully");
				System.out.println("message is added to mav");
				
			 }
				else {
					 beneficiary = new BeneficiaryDetails();
					
					beneficiary.setBenAccNo(benAccountNumber); 
					beneficiary.setBenName(benName);
					beneficiary.setBenPhone(benPhone);
					beneficiary.setBenBank(benBank);
					beneficiary.setBenIfsc(benIfsc);
					beneficiary.setBenDesc(benDesc);
					
					custDetails.getBeneficiaryDetails().add(beneficiary);
					registerRepository.mergeCustomer(custDetails);
					System.out.println("Stored the log on the logRepository");
					View view = new InternalResourceView("debit.jsp");
					mav = new ModelAndView(view);
					System.out.println("view is added to mav");
					mav.addObject("message", "Customer details added Successfully");
					System.out.println("message is added to mav");
				}
   }
				
    }

			else {
				System.out.println("benList is zero");
				System.out.println("add totally a NEW beneficary....");
				
				BeneficiaryDetails beneficiary = new BeneficiaryDetails();
				
				beneficiary.setBenAccNo(benAccountNumber); 
				beneficiary.setBenName(benName);
				beneficiary.setBenPhone(benPhone);
				beneficiary.setBenBank(benBank);
				beneficiary.setBenIfsc(benIfsc);
				beneficiary.setBenDesc(benDesc);
				
				custDetails.getBeneficiaryDetails().add(beneficiary);
				registerRepository.mergeCustomer(custDetails);
				System.out.println("Stored the log on the logRepository");
				View view = new InternalResourceView("userhome.jsp");
				mav = new ModelAndView(view);
				System.out.println("view is added to mav");
				mav.addObject("message", "Customer details added Successfully");
				System.out.println("message is added to mav");
			
			}

			
			System.out.println("returning mav....");
			return mav;
		} 
		
		
		catch (Exception e) {
			View view = new InternalResourceView("errorpage.jsp");
			mav = new ModelAndView(view);			
			mav.addObject("message", "Invalid Credentials. Please Try again...");
			return mav;
		}
		
	}

}




