package org.cit.shoppinglist.service;

import java.util.List;

import org.cit.shoppinglist.dao.SharedUserListDao;
import org.cit.shoppinglist.dao.UserDao;
import org.cit.shoppinglist.dao.UserListDao;
import org.cit.shoppinglist.model.SharedUserList;
import org.cit.shoppinglist.model.User;
import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The UserServiceImpl class is the implementation of UserService and this class
 * is used to provide User related services
 *
 */

@Service
public class UserServiceImpl implements UserService {

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserListDao userListDao;

	@Autowired
	private SharedUserListDao sharedUserListDao;

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

		} catch (Exception ex) {
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
		try {
			log.info("Saving UserList");

			userListDao.saveUserListItem(userListItem);

		} catch (Exception ex) {
			log.error("Error in Saving UserList");
			ex.printStackTrace();
		}

	}

	@Override
	public boolean checkListSharedToUser(int userListId, int userId) {
		try {
			log.info("Saving SharedUserList");

			return sharedUserListDao.checkListSharedToUser(userListId, userId);

		} catch (Exception ex) {
			log.error("Error in Saving SharedUserList");
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public void saveSharedUserList(SharedUserList sharedUserList) {
		try {
			log.info("Saving SharedUserList");

			sharedUserListDao.saveSharedUserList(sharedUserList);

		} catch (Exception ex) {
			log.error("Error in Saving SharedUserList");
			ex.printStackTrace();
		}
	}

	@Override
	public List<UserList> getSharedUserListsByUserId(int userId) {
		List<UserList> userLists = sharedUserListDao.getSharedUserListsByUserId(userId);

		// fetch and set userListItems to each userList
		for (UserList userList : userLists) {
			List<UserListItem> userListItems = userListDao.getUserListItemsByUserListId(userList.getId());
			userList.setUserListItems(userListItems);
		}

		return userLists;
	}

	@Override
	public void markUnmarkUserListItem(int userListItemId, boolean purchased) {
		try {
			log.info("Mark/Unmark: " + purchased + " UserListItem: " + userListItemId);

			userListDao.markUnmarkUserListItem(userListItemId, purchased);

		} catch (Exception ex) {
			log.error("Error in mark/unmark UserListItem");
			ex.printStackTrace();
		}
	}

	/**
	 * The getUserListFromUser() method is used to get new UserList instance
	 * using User instance
	 * 
	 * @param user
	 *            Specifies the User instance
	 * @return Return new UserList instance
	 */
	private UserList getUserListFromUser(User user) {
		String userListName = user.getFirstName() + " " + user.getLastName() + " List";

		UserList userList = new UserList();
		userList.setName(userListName);
		userList.setUserId(user.getId());

		return userList;
	}
}
