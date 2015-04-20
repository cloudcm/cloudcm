package org.cit.shoppinglist.dao;

import java.util.List;

import org.cit.shoppinglist.model.Contact;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface ContactDao {
     
    public void saveOrUpdate(Contact contact);
     
    public void delete(int contactId);
     
    public Contact get(int contactId);
     
    public List<Contact> list();
}
