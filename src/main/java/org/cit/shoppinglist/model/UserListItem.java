package org.cit.shoppinglist.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class UserListItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int userListId;
	private boolean purchased;
	
	@NotEmpty
	private String item;

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
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return the purchased
	 */
	public boolean isPurchased() {
		return purchased;
	}

	/**
	 * @param purchased the purchased to set
	 */
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
}
