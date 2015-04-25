package org.cit.shoppinglist.dao;

import java.util.List;

import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;

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

	UserList getUserListByUserId(int userId);

	List<UserListItem> getUserListItemsByUserListId(int userListId);

	void deleteUserListItem(int userListItemId);

	void saveUserListItem(UserListItem userListItem);
}
