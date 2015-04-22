package org.cit.shoppinglist.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserListController {

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String showUserListingPage(Model model, Principal principal) {
		model.addAttribute("title", "User Shopping List");

		return "userListing";
	}
}
