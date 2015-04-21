package org.cit.shoppinglist.model;

import java.io.Serializable;

/**
 * User Class is used to hold user information
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Short enabled;

	public User() {

	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param enabled
	 */
	public User(int id, String firstName, String lastName, String username, String password, Short enabled) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public Short getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}
}
