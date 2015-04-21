package org.cit.shoppinglist.model;

import java.io.Serializable;

public class SharedUserList implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int userListId;
	private int sharingUserId;
	private int sharedWithUserId;

	private UserList userList;
	private User sharingUser;
	private User sharedWithUser;

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
	 * @return the sharingUserId
	 */
	public int getSharingUserId() {
		return sharingUserId;
	}

	/**
	 * @param sharingUserId
	 *            the sharingUserId to set
	 */
	public void setSharingUserId(int sharingUserId) {
		this.sharingUserId = sharingUserId;
	}

	/**
	 * @return the sharedWithUserId
	 */
	public int getSharedWithUserId() {
		return sharedWithUserId;
	}

	/**
	 * @param sharedWithUserId
	 *            the sharedWithUserId to set
	 */
	public void setSharedWithUserId(int sharedWithUserId) {
		this.sharedWithUserId = sharedWithUserId;
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
	 * @return the sharingUser
	 */
	public User getSharingUser() {
		return sharingUser;
	}

	/**
	 * @param sharingUser
	 *            the sharingUser to set
	 */
	public void setSharingUser(User sharingUser) {
		this.sharingUser = sharingUser;
	}

	/**
	 * @return the sharedWithUser
	 */
	public User getSharedWithUser() {
		return sharedWithUser;
	}

	/**
	 * @param sharedWithUser
	 *            the sharedWithUser to set
	 */
	public void setSharedWithUser(User sharedWithUser) {
		this.sharedWithUser = sharedWithUser;
	}

}
