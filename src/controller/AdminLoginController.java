package controller;
//C call by value and callby address

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//c++ call by value, call by address, call by reference

// java - call by value

import javax.servlet.RequestDispatcher;
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

import entity.AccountDetails;
import entity.AdminLogin;
import entity.CustomerDetails;
import entity.Login;
import repository.JpaAdminLoginRepository;
import repository.AdminLoginRepository;

@Controller
public class AdminLoginController  {

	@Autowired
	private AdminLoginRepository adminLoginRepository;
	

	public AdminLoginController() {
		System.out.println("AdminLoginController() ctor...");
	}

	
	@RequestMapping("/adminlogin.do")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {


		System.out.println("req.getParameter(adminId)");
		System.out.println("req.getParameter(password)");

		String adminId = req.getParameter("adminId");
		System.out.println("Admin Id : " + adminId);
		String password = req.getParameter("password");
		System.out.println("password :  " + password);

		AdminLogin log = new AdminLogin();
		System.out.println("Empty login created...");

		log.setAdminId(adminId);
		log.setPassword(password);
		System.out.println("login object filled up ..");
		
		ModelAndView mav = null;
		
		AdminLogin temp = adminLoginRepository.getLogin(log);
		System.out.println("temp "+temp);
		
		
		if(temp!=null) {
			System.out.println("Login Successful");
			View view = new InternalResourceView("AdminHome.jsp");
			mav  = new ModelAndView(view);
			mav.addObject("message", "Login Successful");
			System.out.println("message is added to mav");
			session.setAttribute("adminid",log.getAdminId() );
		} 
		else {
					
					View view = new InternalResourceView("LoginFailure.jsp");
					System.out.println("view created...for example1.jsp");
					mav = new ModelAndView(view);
					System.out.println("view is added to mav");
					mav.addObject("message", "Login Created Successfully");
					System.out.println("message is added to mav");
			
			
		}

		System.out.println("returning mav....");
		return mav;
	}
	
	@RequestMapping(value="/viewCustomer.do")
	public ModelAndView viewCustomer(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		ModelAndView mav = null;		
		System.out.println("req.getParameter(custId)");
		
		try {
			int custId= Integer.parseInt(req.getParameter("custId"));		
			CustomerDetails cd = adminLoginRepository.viewCustomer(custId);										
			System.out.println(cd.getCustId());
						
			if(cd!=null) {				
				View view = new InternalResourceView("viewCustomer.jsp");
				mav  = new ModelAndView(view);
				mav.addObject("show", cd);
			}			
		} 
		
		
		catch (Exception e) {
			View view = new InternalResourceView("invalid.jsp");
			mav  = new ModelAndView(view);
			mav.addObject("message", "User Id doesnot exist");						
		}
		return mav;
	}
	
	@RequestMapping(value="/viewAll.do")
	public ModelAndView viewAllCustomer(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
	List<CustomerDetails> list = new ArrayList<CustomerDetails>();
	list=adminLoginRepository.viewAllCustomer();
    System.out.println("*** List of all Customers *** "); 
 
    ModelAndView mav = null;
    
    
    for (Iterator i = list.iterator();  i.hasNext();) {
        CustomerDetails cus = (CustomerDetails) i.next();
        
      
        System.out.println("Customer Id " + cus.getCustId());
        System.out.println("Customer Name " + cus.getCustName());
        System.out.println("Customer Address " + cus.getAddress());
        System.out.println("Customer City " + cus.getCity());
        System.out.println("Customer Country " + cus.getCountry());
        System.out.println("Customer Pincode " + cus.getPincode());
        System.out.println("Customer DateOfBirth " + cus.getDateOfBirth());
        System.out.println("Customer Gender " + cus.getGender());
        System.out.println("Customer MobileNo " + cus.getMobileNo());
        System.out.println("Customer Email Id " + cus.getEmailId());
        System.out.println("Customer AadharNo " + cus.getAadharNo());
        System.out.println("Customer PanNo " + cus.getPanNo());
        System.out.println("Customer AccountDetails" + cus.getAccountDetails().getAccNo()); 
        System.out.println("Customer AccountDetails" + cus.getAccountDetails().getAcctype());  
        System.out.println("Customer AccountDetails" + cus.getAccountDetails().getBalance());  
        System.out.println("Customer AccountDetails" + cus.getAccountDetails().getBranch()); 
        System.out.println("Customer AccountDetails" + cus.getAccountDetails().getDateOfOpening());
      }
    
    
    View view = new InternalResourceView("viewAllCustomer.jsp");
    mav = new ModelAndView(view);
    mav.addObject("view", list);
	return mav;	
	}

}

