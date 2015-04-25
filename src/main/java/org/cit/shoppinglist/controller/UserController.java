package org.cit.shoppinglist.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.cit.shoppinglist.common.Constants;
import org.cit.shoppinglist.model.SharedUserList;
import org.cit.shoppinglist.model.User;
import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;
import org.cit.shoppinglist.service.UserService;
import org.cit.shoppinglist.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String showUserListingPage(ModelMap model, Principal principal, HttpSession session) {

		User user = getLoggedInUser(principal, session);

		UserList userList = userService.getUserListByUserId(user.getId());

		model.addAttribute("userList", userList);
		model.addAttribute("userListItems", userList.getUserListItems());

		UserListItem newUserListItem = new UserListItem();
		newUserListItem.setUserListId(userList.getId());

		model.addAttribute("userListItem", newUserListItem);

		SharedUserList sharedUserList = new SharedUserList();
		sharedUserList.setUserListId(userList.getId());
		sharedUserList.setSharedByUserId(user.getId());

		model.addAttribute("sharedUserList", sharedUserList);

		return Constants.PAGE_USER_LISTING;
	}

	@RequestMapping(value = "/addUserListItem", method = RequestMethod.POST)
	public String addItemToUserList(@Valid UserListItem userListItem, BindingResult bindingResult, HttpSession session) {

		session.removeAttribute("userListItemMessage");

		if (bindingResult.hasErrors()) {
			session.setAttribute("userListItemMessage", "Item can not be empty");
			return Constants.REDIRECT_TO_USER_LISTING_PAGE;
		}

		userService.saveUserListItem(userListItem);

		return Constants.REDIRECT_TO_USER_LISTING_PAGE;
	}

	@RequestMapping(value = "/deleteUserListItem", method = RequestMethod.GET)
	public String deleteUserListItem(HttpServletRequest request) {
		int userListItemId = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserListItem(userListItemId);

		return Constants.REDIRECT_TO_USER_LISTING_PAGE;
	}

	@RequestMapping(value = "/shareUserList", method = RequestMethod.POST)
	public String shareUserListToOtherContact(@Valid SharedUserList sharedUserList, BindingResult bindingResult, Principal principal,
			HttpSession session) {
		
		boolean isValidated = validateUserShareList(sharedUserList, bindingResult, principal, session);
		
		if(isValidated) {
			userService.saveSharedUserList(sharedUserList);
		}

		return Constants.REDIRECT_TO_USER_LISTING_PAGE;
	}

	@RequestMapping(value = "/sharedUserList", method = RequestMethod.GET)
	public String showSharedUserListingPage(ModelMap model, Principal principal, HttpSession session) {

		User user = getLoggedInUser(principal, session);

		List<UserList> sharedUserLists = userService.getSharedUserListsByUserId(user.getId());

		model.addAttribute("sharedUserLists", sharedUserLists);

		return Constants.PAGE_SHARED_USER_LISTING;
	}

	private User getLoggedInUser(Principal principal, HttpSession session) {
		User user = null;

		if (session.getAttribute("loggedInUser") == null) {
			String username = principal.getName();
			user = userService.getUserByUsername(username);
		} else {
			user = (User) session.getAttribute("loggedInUser");
		}

		return user;
	}

	@RequestMapping(value = "/markUserListItem", method = RequestMethod.POST)
	public @ResponseBody Boolean markUserListItem(@RequestParam(value = "userListItemId", required = true) Integer userListItemId,
			@RequestParam(value = "marked", required = true) Boolean marked) {

		log.info("userListItemId: " + userListItemId);
		log.info("marked: " + marked);

		userService.markUnmarkUserListItem(userListItemId, marked);

		return marked;
	}

	private boolean validateUserShareList(SharedUserList sharedUserList, BindingResult bindingResult, Principal principal, HttpSession session) {
		session.removeAttribute("shareToUsernameMessage");
		
		if (bindingResult.hasErrors()) {
			session.setAttribute("shareToUsernameMessage", "Username can not be empty");
			return false;
		}

		String username = principal.getName();

		if (username.equalsIgnoreCase(sharedUserList.getShareToUsername())) {
			session.setAttribute("shareToUsernameMessage", "Invalid Username");
			return false;
		}

		User user = userService.getUserByUsername(sharedUserList.getShareToUsername());

		if (user != null) {

			sharedUserList.setSharedToUserId(user.getId());

			boolean isListShared = userService.checkListSharedToUser(sharedUserList.getUserListId(), sharedUserList.getSharedToUserId());

			if (isListShared) {
				session.setAttribute("shareToUsernameMessage", "Your list already shared with " + sharedUserList.getShareToUsername());
				return false;
			}
		} else {
			session.setAttribute("shareToUsernameMessage", "Invalid Username");
			return false;
		}

		return true;
	}
}
