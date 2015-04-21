package org.cit.shoppinglist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.cit.shoppinglist.model.Contact;
import org.cit.shoppinglist.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/contacts")
	public ModelAndView listContact(ModelAndView model) throws IOException {
		List<Contact> listContact = contactService.getAllContacts();
		
		model.addObject("listContact", listContact);
		model.setViewName("home");

		return model;
	}

	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("ContactForm");
		return model;
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactService.saveContact(contact);
		
		return new ModelAndView("redirect:/contacts");
	}

	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactService.deleteContact(contactId);
		
		return new ModelAndView("redirect:/contacts");
	}

	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactService.getContactById(contactId);
		
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", contact);

		return model;
	}
}
