package org.cit.shoppinglist.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.cit.shoppinglist.model.Product;
import org.cit.shoppinglist.model.User;
import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;
import org.cit.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/signupUser", method = RequestMethod.POST)
	public String createNewUser(@Valid User user, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
            return "signupForm";
        }
		
		userService.createUser(user);
		
		return "redirect:/login";
	}

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String showUserListingPage(Model model, Principal principal) {
		String username = principal.getName();
		
		User user = userService.getUserByUsername(username);
		UserList userList = userService.getUserListByUserId(user.getId());
		
		model.addAttribute("userList", userList);
		model.addAttribute("userListItems", userList.getUserListItems());
		
		UserListItem newUserListItem = new UserListItem();
		newUserListItem.setUserListId(userList.getId());
		
		model.addAttribute("newUserListItem", newUserListItem);

		return "userListing";
	}
	
	@RequestMapping(value = "/addUserListItem", method = RequestMethod.POST)
	public String addItemToUserList(@Valid UserListItem userListItem, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
            return "userListing";
        }
		
		userService.saveUserListItem(userListItem);
		
		return "redirect:/user/userList";
	}
	
	@RequestMapping(value = "/deleteUserListItem", method = RequestMethod.GET)
	public String deleteUserListItem(HttpServletRequest request) {
		int userListItemId = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserListItem(userListItemId);
		
		return "redirect:/user/userList";
	}
}
