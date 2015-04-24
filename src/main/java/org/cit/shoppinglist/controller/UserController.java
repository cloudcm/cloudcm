package org.cit.shoppinglist.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.cit.shoppinglist.model.SharedUserList;
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
		
		User tempUser = userService.getUserByUsername(user.getUsername());
		
		if(tempUser != null) {
			bindingResult.rejectValue("username", "error.user", "An account already exists for this Username.");
			return "signupForm";
		}
 		
		userService.createUser(user);
		
		return "redirect:/login";
	}

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String showUserListingPage(Model model, Principal principal, HttpSession session) {
		
		User user = getLoggedInUser(principal, session);
		
		UserList userList = userService.getUserListByUserId(user.getId());
		
		model.addAttribute("userList", userList);
		model.addAttribute("userListItems", userList.getUserListItems());
		
		UserListItem newUserListItem = new UserListItem();
		newUserListItem.setUserListId(userList.getId());
		
		model.addAttribute("newUserListItem", newUserListItem);
		
		SharedUserList sharedUserList = new SharedUserList();
		sharedUserList.setUserListId(userList.getId());
		sharedUserList.setSharedByUserId(user.getId());
		
		model.addAttribute("sharedUserList", sharedUserList);

		return "userListing";
	}

	@RequestMapping(value = "/addUserListItem", method = RequestMethod.POST)
	public String addItemToUserList(@Valid UserListItem userListItem, BindingResult bindingResult, HttpSession session) {
		
		if (bindingResult.hasErrors()) {
			return "redirect:/user/userList";
        }
		
		return "redirect:/user/userList";
	}
	
	@RequestMapping(value = "/deleteUserListItem", method = RequestMethod.GET)
	public String deleteUserListItem(HttpServletRequest request) {
		int userListItemId = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserListItem(userListItemId);
		
		return "redirect:/user/userList";
	}
	
	@RequestMapping(value = "/shareUserList", method = RequestMethod.POST)
	public String shareUserListToOtherContact(@Valid SharedUserList sharedUserList, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
            return "userListing";
        }
		
		User user = userService.getUserByUsername(sharedUserList.getShareToUsername());
		
		if(user != null) {
			
			sharedUserList.setSharedToUserId(user.getId());
			
			boolean isListShared = userService.checkListSharedToUser(sharedUserList.getUserListId(), sharedUserList.getSharedToUserId());
			
			if(isListShared) {
				bindingResult.rejectValue("shareToUsername", "error.sharedUserList", "Your list already shared with " + sharedUserList.getShareToUsername());
				return "userListing";
			}
			
			userService.saveSharedUserList(sharedUserList);
		}
		
		return "redirect:/user/userList";
	}
	
	private User getLoggedInUser(Principal principal, HttpSession session) {
		User user = null;
		
		if(session.getAttribute("loggedInUser") == null) {
			String username = principal.getName();
			user = userService.getUserByUsername(username);
		} else {
			user = (User) session.getAttribute("loggedInUser");
		}
		
		return user;
	}
}
