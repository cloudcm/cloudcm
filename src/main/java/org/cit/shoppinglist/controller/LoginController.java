package org.cit.shoppinglist.controller;

import java.security.Principal;

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

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String loginPage(Model model, Principal principal) {
		model.addAttribute("title", "User Info");

		String userName = principal.getName();

		model.addAttribute("message", "User Info - This is protected page!. Hello " + userName);

		return "userInfoPage";
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
}
