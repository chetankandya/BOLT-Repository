package controller;
//C call by value and callby address

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

import entity.*;
import repository.AccountDao;
import repository.JpaLoginRepository;
import repository.LoginRepository;
import repository.RegisterRepository;

@Controller
public class LoginController {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private RegisterRepository registerRepository;

	public LoginController() {
		System.out.println("LoginController() ctor...");
	}

	@RequestMapping("/login.do")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws Exception {

		String custId = req.getParameter("custId").trim().toLowerCase();

		String password = req.getParameter("password");

		int customerId = 0;
		try {
			customerId = Integer.parseInt(custId);
		} catch (Exception e) {

		}

		Login log = new Login();

		log.setCustId(customerId);
		log.setPassword(password);

		ModelAndView mav = null;

		Login temp = loginRepository.getLogin(log);

		if (temp != null) {

			session.setAttribute("customerdetails", temp);

			CustomerDetails custdet = registerRepository.getCustomer(temp.getCustId());

			if (accountDao.getAccount(temp.getCustId()) != null) {

				View view = new InternalResourceView("userhome.jsp");
				mav = new ModelAndView(view);

				AccountDetails ad = accountDao.getAccount(temp.getCustId());
				session.setAttribute("ad", ad);

				CustomerDetails cust = registerRepository.getCustomer(temp.getCustId());
				session.setAttribute("cust", cust);

				System.out.println("message is added to mav");

			}

			else {

				View view = new InternalResourceView("accountDetails.jsp");
				mav = new ModelAndView(view);
				mav.addObject("message", "Account Creation Successful");
				System.out.println("message is added to mav");
			}
		} else {

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

	@RequestMapping(value = "/forgot.do", method = RequestMethod.POST)
	public String forgotpass(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("req.getParameter(custId)");
		System.out.println("req.getParameter(Aadhar Number)");
		System.out.println("req.getParameter(Pan Card)");

		String custId = req.getParameter("custId");
		System.out.println("Customer Id : " + custId);
		String aadharNo = req.getParameter("aadharNo");
		System.out.println("Aadhar Number : " + aadharNo);
		String panNo = req.getParameter("panNo");
		System.out.println("Pan Number :  " + panNo);

		int customerId = 0;
		try {
			customerId = Integer.parseInt(custId);
		} catch (Exception e) {

		}

		Login log = new Login();
		System.out.println("forgot login created...");

		log.setCustId(customerId);
		log.setAadharNo(aadharNo);
		log.setPanNo(panNo);
		System.out.println("forgot object filled up ..");

		Login temp = loginRepository.updateLogin(log);
		System.out.println("temp " + temp);

		if (temp != null) {
			System.out.println("Valid Details");
			return "ChangePassword";
		} else {
			return "LoginFailure";
		}
	}

	@RequestMapping(value = "/reset.do", method = RequestMethod.POST)
	public String resetpass(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String custId = req.getParameter("custId");
		System.out.println("User Id : " + custId);
		String password = req.getParameter("password");
		System.out.println("Password : " + password);
		String password1 = req.getParameter("password1");
		System.out.println("Confirm Password :  " + password1);

		int customerId = Integer.parseInt(custId);

		if (password.equals(password1)) {

			Login log = new Login();
			System.out.println("reset created...");

			log.setCustId(customerId);
			log.setPassword(password);
			System.out.println("reset filled up ..");

			Login temp = loginRepository.resetLogin(log);
			System.out.println("temp " + temp);

			if (temp != null) {
				System.out.println("Password Changed");
				return "login";
			} else {
				return "LoginFailure";
			}
		} else {
			System.out.println("Password not matched");
			return "ChangePassword";
		}

	}

	@RequestMapping(value = "/get.do")
	public ModelAndView get(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

		Login t = (Login) session.getAttribute("customerdetails");
		System.out.println("t is " + t);
		CustomerDetails custDetails = registerRepository.getCustomer(new Integer(t.getCustId()));
		System.out.println("cust id : " + custDetails.getCustId());

		String customerid = (String) session.getAttribute("customerid");
		CustomerDetails cd = registerRepository.getCustomer(custDetails.getCustId());
		View view = new InternalResourceView("updateProfile.jsp");
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("details", cd);

		return mav;
	}

	@RequestMapping(value = "/update.do")
	public String update(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

		Login t = (Login) session.getAttribute("customerdetails");
		System.out.println("t is " + t);
		CustomerDetails custDetails = registerRepository.getCustomer(t.getCustId());
		System.out.println("cust id : " + custDetails.getCustId());
		String customerid = (String) session.getAttribute("customerid");
		String custName = req.getParameter("custName");
		String mobileNo = req.getParameter("mobileNo");
		String emailId = req.getParameter("emailId");
		String dateOfBirth = req.getParameter("dateOfBirth");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String country = req.getParameter("country");
		String pincode = req.getParameter("pincode");
		CustomerDetails cd1 = registerRepository.updateProfile(custDetails.getCustId(), custName, mobileNo, emailId,
				dateOfBirth, address, city, country, pincode);

		if (cd1 != null)
			return "updated";
		else
			return null;

	}

}
