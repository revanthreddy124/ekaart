package com.niit.ekaartbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekaartbackend.dao.ContactDAO;
import com.niit.ekaartbackend.model.Contact;

public class ContactTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ContactDAO contactDAO;
	@Autowired
	static Contact contact;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the categoryDAO from context
		contactDAO = (ContactDAO) context.getBean("contactDAO");

		// get the category from context

		contact = (Contact) context.getBean("contact");

	}
//@Ignore
	@Test
	public void createContactTestCase() {
		contact.setName("anaha reddy");
		contact.setEmail("ahanaredddyonce@gmail.com");
		contact.setContact("8374312050");
		contact.setMessage("Original : You designed a very good web application");
contact.setId(111); 
		boolean flag = contactDAO.save(contact);

		assertEquals("createContactTestCase", true, flag);

	}
@Ignore
	@Test
	public void updateContactTestCase() {

		boolean flag = contactDAO.delete(0);

		assertEquals("updateContactTestCase", true, flag);

	}
@Ignore
	@Test
	public void listAllContactTestCase() {
		int actualSize = contactDAO.list().size();
		assertEquals(1, actualSize);
	}

}
