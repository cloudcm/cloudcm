package org.cit.shoppinglist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * UserList Class is used to hold user list information
 * 
 */
public class UserList implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int userId;
	private String name;
	private List<UserListItem> userListItems = new ArrayList<UserListItem>();

	public UserList() {

	}
	
	/**
	 * @param id
	 * @param userId
	 * @param name
	 * @param user
	 * @param products
	 */
	public UserList(int id, int userId, String name, List<UserListItem> userListItems) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.userListItems = userListItems;
	}

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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the userListItems
	 */
	public List<UserListItem> getUserListItems() {
		return userListItems;
	}

	/**
	 * @param userListItems the userListItems to set
	 */
	public void setUserListItems(List<UserListItem> userListItems) {
		this.userListItems = userListItems;
	}

}
