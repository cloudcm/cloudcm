package org.cit.shoppinglist.service;

import java.util.List;

import org.cit.shoppinglist.dao.UserDao;
import org.cit.shoppinglist.dao.UserListDao;
import org.cit.shoppinglist.model.User;
import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserListDao userListDao;

	@Transactional
	@Override
	public int createUser(User user) {
		int userId = 0;
		
		try {
			userId = userDao.createUser(user);
			user.setId(userId);
			log.info("User Created with Id " + userId);
			
			UserList userList = getUserListFromUser(user);
			int userListId = userListDao.createUserList(userList);
			log.info("UserList Created with Id " + userListId);
			
		} catch(Exception ex) {
			log.error("Error in creating User");
			ex.printStackTrace();
		}
		
		return userId;
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserbyUsername(username);
	}
	
	@Override
	public UserList getUserListByUserId(int userId) {
		UserList userList = userListDao.getUserListByUserId(userId);
		
		List<UserListItem> userListItems = userListDao.getUserListItemsByUserListId(userList.getId());
		
		userList.setUserListItems(userListItems);
		
		return userList;
	}
	
	@Override
	public void deleteUserListItem(int userListItemId) {
		try {
			log.info("Deleting UserListItem by Id: " + userListItemId);
			
			userListDao.deleteUserListItem(userListItemId);
			
		} catch (Exception ex) {
			log.error("Error in Deleting UserListItem");
			ex.printStackTrace();
		}
	}
	
	@Override
	public void saveUserListItem(UserListItem userListItem) {
		userListDao.saveUserListItem(userListItem);
	}

	private UserList getUserListFromUser(User user) {
		String userListName = user.getFirstName() + " " + user.getLastName() + " List";
		
		UserList userList = new UserList();
		userList.setName(userListName);
		userList.setUserId(user.getId());
		
		return userList;
	}
}
