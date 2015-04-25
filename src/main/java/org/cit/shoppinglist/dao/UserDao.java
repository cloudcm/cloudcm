package org.cit.shoppinglist.dao;

import org.cit.shoppinglist.model.User;

/**
 * The UserDao interface is used to handle User related database operations
 *
 */
public interface UserDao {

	/**
	 * The createUser() method is used to create new user with a role i.e.
	 * USER_ROLE
	 * 
	 * @param user
	 *            Specifies the User instance
	 * @return Return new created user identifier
	 */
	int createUser(User user);

	/**
	 * The getUserbyUsername() method is used to get User instance by username
	 * 
	 * @param username
	 *            Specifies the username of a user
	 * @return Return User instance
	 */
	User getUserbyUsername(String username);
}
