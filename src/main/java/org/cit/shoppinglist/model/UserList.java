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
	private User user;
	private List<Product> products = new ArrayList<Product>(); // this list represents UserListProduct entity

	public UserList() {

	}
	
	/**
	 * @param id
	 * @param userId
	 * @param name
	 * @param user
	 * @param products
	 */
	public UserList(int id, int userId, String name, User user, List<Product> products) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.user = user;
		this.products = products;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
