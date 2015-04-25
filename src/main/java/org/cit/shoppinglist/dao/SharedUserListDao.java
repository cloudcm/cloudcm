package org.cit.shoppinglist.dao;

import java.util.List;

import org.cit.shoppinglist.model.SharedUserList;
import org.cit.shoppinglist.model.UserList;

public interface SharedUserListDao {

	boolean checkListSharedToUser(int userListId, int userId);

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

	void markUnmarkUserListItem(int userListItemId, boolean purchased);
}
