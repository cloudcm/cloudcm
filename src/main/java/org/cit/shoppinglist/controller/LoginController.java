package org.cit.shoppinglist.controller;

import java.security.Principal;

import org.cit.shoppinglist.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("title", "Login");
		
		return "loginForm";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		
		return "loginForm";
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		model.addAttribute("title", "Access Denied!");

		if (principal != null) {
			model.addAttribute("message", "Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "accessDenied";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "signupForm";
	}
}
