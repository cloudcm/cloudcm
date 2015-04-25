package org.cit.shoppinglist.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

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
	
	@NotEmpty
	private String shareToUsername;

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
	 * @return the shareToUsername
	 */
	public String getShareToUsername() {
		return shareToUsername;
	}

	/**
	 * @param shareToUsername the shareToUsername to set
	 */
	public void setShareToUsername(String shareToUsername) {
		this.shareToUsername = shareToUsername;
	}
}
