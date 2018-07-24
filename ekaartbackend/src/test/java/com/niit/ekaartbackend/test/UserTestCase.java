package com.niit.ekaartbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekaartbackend.dao.UserDAO;
import com.niit.ekaartbackend.model.User;


public class UserTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

		user = (User) context.getBean("user");

	}
	
	@Test
	public void createUserTestCase() {
		user.setEmail("revanth@gmail.com");
		user.setId("reddy");
		user.setName("revanth Reddy");
		user.setPassword("revanth");
		user.setCountry("India");
		user.setAddress("Hyderabad");
		user.setRole("ROLE_ADMIN");
		user.setContact("8194869957");
		boolean flag = userDAO.save(user);

		assertEquals("createUserTestCase", true, flag);

	}
	
/*	@Test
	public void updateUserTestCase() {
		user.setEmail("isaacdv84@gmail.com");
		user.setId("IsaacDV");
		user.setName("Isaac Deva Varam");
		user.setPassword("isaac");
		user.setCountry("India");
		user.setAddress("Hyderabad");
		user.setRole("ROLE_USER");
		user.setContact("9490167876");
		boolean flag = userDAO.update(user);

		assertEquals("updateUserTestCase", true, flag);

	}

	@Test
	public void validateUserTestCase() {

		boolean flag = userDAO.validate("IsaacDV", "isaac");
		assertEquals(true, flag);

	}

	@Test
	public void listAllUserTestCase() {
		int actualSize = userDAO.list().size();
		assertEquals(5, actualSize);
	}*/

}
