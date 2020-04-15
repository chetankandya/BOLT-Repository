package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import org.springframework.web.servlet.view.InternalResourceView;

import entity.CustomerDetails;
import repository.JpaRegisterRepository;
import repository.RegisterRepository;

@Controller
public class RegisterController{
	
	@Autowired
	private RegisterRepository registerRepository;

	public RegisterController() {
		System.out.println("RegisterController() ctor...");
	}

	@RequestMapping("/register.do")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("req.getParameter(custId)");
		System.out.println("req.getParameter(custName)");
		System.out.println("req.getParameter(mobileNo)");
		System.out.println("req.getParameter(gender)");
		System.out.println("req.getParameter(aadharNo)");
		System.out.println("req.getParameter(emailId)");
		System.out.println("req.getParameter(panNo)");
		System.out.println("req.getParameter(dateOfBirth)");
		System.out.println("req.getParameter(password)");
		System.out.println("req.getParameter(address)");
		System.out.println("req.getParameter(city)");
		System.out.println("req.getParameter(country)");
		System.out.println("req.getParameter(pincode)");



		String custId = req.getParameter("custId").trim();
		System.out.println("Customer Id : " + custId);
		
		int customerId=Integer.parseInt(custId);
		
		String custName = req.getParameter("custName");
		System.out.println("Customer Name :  " + custName);
		
		String mobileNo = req.getParameter("mobileNo");
		System.out.println("Mobile No : " + mobileNo);
		
		String gender = req.getParameter("gender");
		System.out.println("Gender:  " + gender);
		
		String aadharNo = req.getParameter("aadharNo");
		System.out.println("Aadhar No : " + aadharNo);
		
		String emailId = req.getParameter("emailId");
		System.out.println("Email Id :  " + emailId);
		
		String panNo = req.getParameter("panNo");
		System.out.println("Pan No : " + panNo);
		
		String dateOfBirth = req.getParameter("dateOfBirth");
		System.out.println("Date of Birth :  " + dateOfBirth);
		
		String password = req.getParameter("password");
		System.out.println("Password :  " + password);
		
		String address = req.getParameter("address");
		System.out.println("Address :  " + address);
		
		String city = req.getParameter("city");
		System.out.println("City :  " + city);
		
		String country = req.getParameter("country");
		System.out.println("Country : " + country);
	
		String pincode = req.getParameter("pincode");
		System.out.println("Pincode :  " + pincode);
		

		CustomerDetails log = new CustomerDetails();
		System.out.println("Empty data created...");

		 log.setCustId(customerId);
		 log.setCustName(custName);
		 log.setMobileNo(mobileNo);
		 log.setGender(gender);
		 log.setAadharNo(aadharNo);
		 log.setEmailId(emailId);
		 log.setPanNo(panNo);
		 log.setDateOfBirth(dateOfBirth);
		 log.setPassword(password);
		 log.setAddress(address);
		 log.setCity(city);
		 log.setCountry(country);
		 log.setPincode(pincode);
		 
		System.out.println("register object filled up ..");
		
		ModelAndView mav = null;
		
		CustomerDetails temp = registerRepository.getCustomer(log.getCustId());
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
					registerRepository.addCustomer(log);
					System.out.println("Stored the log on the logRepository");
					View view = new InternalResourceView("login.jsp");
					mav = new ModelAndView(view);
					System.out.println("view is added to mav");
					mav.addObject("message", "Customer details added Successfully");
					System.out.println("message is added to mav");
		}

		

		System.out.println("returning mav....");
		return mav;
	}

}
