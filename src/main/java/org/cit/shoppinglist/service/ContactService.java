package org.cit.shoppinglist.service;

import java.util.List;

import org.cit.shoppinglist.model.Contact;

public interface ContactService {
	
	void saveContact(Contact contact);

	void deleteContact(int contactId);

	Contact getContactById(int contactId);

	List<Contact> getAllContacts();
}
