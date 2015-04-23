package org.cit.shoppinglist.dao;

import org.cit.shoppinglist.model.User;

public interface UserDao {
     
    int createUser(User user);

	User getUserbyUsername(String username);
}
