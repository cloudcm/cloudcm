package org.cit.shoppinglist.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.cit.shoppinglist.common.Constants;
import org.cit.shoppinglist.model.User;
import org.cit.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error, ModelMap model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return Constants.REDIRECT_TO_USER_LISTING_PAGE;
		}
		
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return Constants.REDIRECT_TO_USER_LISTING_PAGE;
		}
		
		User user = new User();
		model.addAttribute("user", user);
		
		return Constants.PAGE_SIGNUP;
	}
	
	@RequestMapping(value = "/signupUser", method = RequestMethod.POST)
	public String createNewUser(@Valid User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return Constants.PAGE_SIGNUP;
		}

		User tempUser = userService.getUserByUsername(user.getUsername());

		if (tempUser != null) {
			bindingResult.rejectValue("username", "error.user", "An account already exists for this Username.");
			return Constants.PAGE_SIGNUP;
		}

		userService.createUser(user);

		return Constants.REDIRECT_TO_LOGIN_PAGE;
	}
}
