package org.cit.shoppinglist.dao;

import java.util.List;

import org.cit.shoppinglist.model.SharedUserList;
import org.cit.shoppinglist.model.UserList;

/**
 * The SharedUserListDao interface is used to handle User's Shared Shopping List
 * related database operations
 *
 */
public interface SharedUserListDao {

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
	 * The getSharedUserListsByUserId() method will fetch all shared userLists
	 * of the given userId
	 * 
	 * @param userId
	 *            specifies userId
	 * @return list of shared userLists
	 */
	List<UserList> getSharedUserListsByUserId(int userId);
	
}
