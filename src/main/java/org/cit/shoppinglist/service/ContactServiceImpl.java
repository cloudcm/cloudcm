package org.cit.shoppinglist.service;

import java.util.List;

import org.cit.shoppinglist.dao.ContactDao;
import org.cit.shoppinglist.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;

	@Override
	public void saveContact(Contact contact) {
		try {
			contactDao.saveOrUpdate(contact);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteContact(int contactId) {
		try {
			contactDao.delete(contactId);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public Contact getContactById(int contactId) {
		try {
			return contactDao.get(contactId);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		try {
			return contactDao.list();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

}
