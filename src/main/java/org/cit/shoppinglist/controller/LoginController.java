package org.cit.shoppinglist.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.cit.shoppinglist.common.Constants;
import org.cit.shoppinglist.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage(ModelMap model, HttpSession session) {
		
		if(session.getAttribute("SPRING_SECURITY_CONTEXT") != null) {
			return Constants.REDIRECT_TO_USER_LISTING_PAGE;
		}
		
		return Constants.PAGE_LOGIN;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutSuccessfulPage(ModelMap model) {
		
		return Constants.PAGE_LOGIN;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(ModelMap model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message", "Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		
		return Constants.PAGE_ACCESS_DENIED;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return Constants.PAGE_SIGNUP;
	}
}
