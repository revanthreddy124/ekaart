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
		context.scan("com");
		context.refresh();

		contactDAO = (ContactDAO) context.getBean("contactDAO");

		
		contact = (Contact) context.getBean("contact");

	}
@Ignore
	@Test
	public void createContactTestCase() {
		contact.setName("C.Seshagiri Rao");
		contact.setEmail("seshagirirao@gmail.com");
		contact.setContact("8194869957");
		contact.setMessage("Original : You designed a  web application");

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
