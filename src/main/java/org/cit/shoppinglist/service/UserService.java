package org.cit.shoppinglist.service;

import org.cit.shoppinglist.model.SharedUserList;
import java.util.List;

import org.cit.shoppinglist.model.User;
import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;

public interface UserService {
	
	int createUser(User user);

	UserList getUserListByUserId(int userId);

	User getUserByUsername(String username);

	void deleteUserListItem(int userListItemId);

	void saveUserListItem(UserListItem userListItem);

	boolean checkListSharedToUser(int userListId, int userId);
	
	void saveSharedUserList(SharedUserList sharedUserList);

	/**
	 * getSharedUserListsByUserId method will fetch all shared userLists of 
	 * 		the given userId
	 * @param userId
	 * 		specifies userId
	 * @return
	 * 		list of shared userLists
	 */
	List<UserList> getSharedUserListsByUserId(int userId);
}
