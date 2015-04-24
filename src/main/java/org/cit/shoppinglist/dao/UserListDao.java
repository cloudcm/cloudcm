package org.cit.shoppinglist.dao;

import java.util.List;

import org.cit.shoppinglist.model.SharedUserList;
import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;

public interface UserListDao {
     
    int createUserList(UserList userList);

	UserList getUserListByUserId(int userId);

	List<UserListItem> getUserListItemsByUserListId(int userListId);

	void deleteUserListItem(int userListItemId);

	void saveUserListItem(UserListItem userListItem);

	void saveSharedUserList(SharedUserList sharedUserList);

	boolean checkListSharedToUser(int userListId, int userId);
	
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
