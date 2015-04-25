package org.cit.shoppinglist.dao;

import java.util.List;

import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;

/**
 * The UserListDao interface is used to handle User's Shopping List related database
 * operations
 *
 */
public interface UserListDao {

	/**
	 * The createUserList() method is used to create new shopping list for user
	 * in DB
	 * 
	 * @param userList
	 *            Specifies the UserList instance
	 * @return Return Id of new user list
	 */
	int createUserList(UserList userList);

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
	 * The getUserListItemsByUserListId() method is used to get UserListItems of
	 * given user list identifier
	 * 
	 * @param userListId
	 *            Specifies the user list identifier
	 * @return Return list of UserListItem for given user list identifier
	 */
	List<UserListItem> getUserListItemsByUserListId(int userListId);

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
