package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import entity.AdminDetails;
//import repository.JpaAdminRepository;
import repository.AdminRepository;

@Controller
public class AdminController{
	
	@Autowired
	private AdminRepository adminRepository;

	public AdminController() {
		System.out.println("AdminController() ctor...");
	}

	@RequestMapping("/addAdmin.do")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("req.getParameter(adminId)");
		System.out.println("req.getParameter(adminName)");
		System.out.println("req.getParameter(mobileNo)");
		System.out.println("req.getParameter(emailId)");
		System.out.println("req.getParameter(password)");
		
		String adminId = req.getParameter("adminId");
		System.out.println("Admin Id : " + adminId);
		
		String  adminName = req.getParameter("adminName");
		System.out.println("Admin Name :  " +  adminName);
		
		String mobileNo = req.getParameter("mobileNo");
		System.out.println("Mobile No : " + mobileNo);
		
		String emailId = req.getParameter("emailId");
		System.out.println("Email Id :  " + emailId);
		
		String password = req.getParameter("password");
		System.out.println("Password :  " + password);
		

		AdminDetails log = new  AdminDetails();
		System.out.println("Empty data created...");

		 log.setAdminId(adminId);
		 log.setAdminName(adminName);
		 log.setMobileNo(mobileNo);
		 log.setEmailId(emailId);
		 log.setPassword(password);
	
		 
		System.out.println("register object filled up ..");
		
		ModelAndView mav = null;
		
		AdminDetails temp = adminRepository.getAdmin(log.getAdminId());
		System.out.println("temp "+temp);
		
		
		if(temp!=null) {
			System.out.println("Object already exists!!!");
			View view = new InternalResourceView("UserAlreadyExist.jsp");
			mav  = new ModelAndView(view);
			mav.addObject("message", "User Already Present");
			System.out.println("message is added to mav");
		} 
		else {
					System.out.println("Storing the log on the logRepository");
					adminRepository.addAdmin(log);
					System.out.println("Stored the log on the logRepository");
					View view = new InternalResourceView("AdminHome.jsp");
					mav = new ModelAndView(view);
					System.out.println("view is added to mav");
					mav.addObject("message", "Admin details added Successfully");
					System.out.println("message is added to mav");
		}

		

		System.out.println("returning mav....");
		return mav;
	}

}
