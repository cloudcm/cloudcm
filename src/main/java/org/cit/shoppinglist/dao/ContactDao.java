package org.cit.shoppinglist.dao;

import java.util.List;

import org.cit.shoppinglist.model.Contact;

public interface ContactDao {
     
    void saveOrUpdate(Contact contact);
     
    void delete(int contactId);
     
    Contact get(int contactId);
     
    List<Contact> list();
}
