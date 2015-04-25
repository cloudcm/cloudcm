package org.cit.shoppinglist.service;

import org.cit.shoppinglist.model.SharedUserList;
import java.util.List;

import org.cit.shoppinglist.model.User;
import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;

/**
 * The UserService interface is used to provide User related services
 *
 */
public interface UserService {

	/**
	 * The createUser() method is used to create new user with a role i.e.
	 * USER_ROLE and also create empty/new user list
	 * 
	 * @param user
	 *            Specifies the User instance
	 * @return Return new created user identifier
	 */
	int createUser(User user);

	/**
	 * The getUserbyUsername() method is used to get User instance by username
	 * 
	 * @param username
	 *            Specifies the username of a user
	 * @return Return User instance
	 */
	User getUserByUsername(String username);

	/**
	 * The getUserListByUserId() method is used to get user list from DB by
	 * given user identifier
	 * 
	 * @param userId
	 *            Specifies User identifier
	 * @return Return UserList for given user identifier
	 */
	UserList getUserListByUserId(int userId);

	/**
	 * The deleteUserListItem() method is used to delete UserListItem of given
	 * identifier
	 * 
	 * @param userListItemId
	 *            Specifies the UserListItem identifier
	 */
	void deleteUserListItem(int userListItemId);

	/**
	 * The saveUserListItem() method is used to save given UserListItem instance
	 * in DB
	 * 
	 * @param userListItem
	 *            Specifies the UserListItem instace
	 */
	void saveUserListItem(UserListItem userListItem);

	/**
	 * The checkListSharedToUser() method is used to check userList already
	 * shared with given user or not
	 * 
	 * @param userListId
	 *            Specifies the UserList identifier
	 * @param userId
	 *            Specifies the User identifier
	 * @return Return True, if list already shared with given user
	 */
	boolean checkListSharedToUser(int userListId, int userId);

	/**
	 * The saveSharedUserList() method is used to save given SharedUserList
	 * instance in DB
	 * 
	 * @param sharedUserList
	 *            Specifies the SharedUserList instance
	 */
	void saveSharedUserList(SharedUserList sharedUserList);

	/**
	 * getSharedUserListsByUserId method will fetch all shared userLists of the
	 * given userId
	 * 
	 * @param userId
	 *            specifies userId
	 * @return list of shared userLists
	 */
	List<UserList> getSharedUserListsByUserId(int userId);

	/**
	 * The markUnmarkUserListItem() method is used to mark/unmark userListItem
	 * as purchased
	 * 
	 * @param userListItemId
	 *            Specifies the UserListItem identifier
	 * @param purchased
	 *            Specifies the list item is purchased or not
	 */
	void markUnmarkUserListItem(int userListItemId, boolean purchased);
}
