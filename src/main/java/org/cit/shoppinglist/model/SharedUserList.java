package org.cit.shoppinglist.model;

import java.io.Serializable;

/**
 * SharedUserList Class is used to hold shared user list information
 * 
 */
public class SharedUserList implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int userListId;
	private int sharedByUserId;
	private int sharedToUserId;

	private UserList userList;
	private User sharedByUser;
	private User sharedToUser;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userListId
	 */
	public int getUserListId() {
		return userListId;
	}

	/**
	 * @param userListId
	 *            the userListId to set
	 */
	public void setUserListId(int userListId) {
		this.userListId = userListId;
	}

	/**
	 * @return the sharedByUserId
	 */
	public int getSharedByUserId() {
		return sharedByUserId;
	}

	/**
	 * @param sharedByUserId
	 *            the sharedByUserId to set
	 */
	public void setSharedByUserId(int sharedByUserId) {
		this.sharedByUserId = sharedByUserId;
	}

	/**
	 * @return the sharedToUserId
	 */
	public int getSharedToUserId() {
		return sharedToUserId;
	}

	/**
	 * @param sharedToUserId
	 *            the sharedToUserId to set
	 */
	public void setSharedToUserId(int sharedToUserId) {
		this.sharedToUserId = sharedToUserId;
	}

	/**
	 * @return the userList
	 */
	public UserList getUserList() {
		return userList;
	}

	/**
	 * @param userList
	 *            the userList to set
	 */
	public void setUserList(UserList userList) {
		this.userList = userList;
	}

	/**
	 * @return the sharedByUser
	 */
	public User getSharedByUser() {
		return sharedByUser;
	}

	/**
	 * @param sharedByUser
	 *            the sharedByUser to set
	 */
	public void setSharedByUser(User sharedByUser) {
		this.sharedByUser = sharedByUser;
	}

	/**
	 * @return the sharedToUser
	 */
	public User getSharedToUser() {
		return sharedToUser;
	}

	/**
	 * @param sharedToUser
	 *            the sharedToUser to set
	 */
	public void setSharedToUser(User sharedToUser) {
		this.sharedToUser = sharedToUser;
	}
}
