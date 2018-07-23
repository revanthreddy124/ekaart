package com.niit.ekaartbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekaartbackend.dao.AddressDAO;
import com.niit.ekaartbackend.model.Address;

public class AddressDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static AddressDAO addressDAO;

	@Autowired
	static Address address;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		addressDAO = (AddressDAO) context.getBean("addressDAO");

		address = (Address) context.getBean("address");

	}
@Ignore
	@Test
	public void createAddressTestCase() {
		address.setId("add124");
		address.setUser_id("rajini");
		address.setH_no("1/6/135");
		address.setStreet("mahendra hills,dilsukhnagar");
		address.setCity("hyderabad");
		address.setCountry("India");
		address.setPin("533004");

		boolean flag = addressDAO.save(address);

		assertEquals("createAddressTestCase", true, flag);

	}
//@Ignore
	@Test
	public void updateAddressTestCase() {
		address.setId("add124");
		address.setUser_id("rajini");
		address.setH_no("1/6/136");
		address.setStreet("teachers colony,dilsukhnagar");
		address.setCity("hyderabad");
		address.setCountry("India");
		address.setPin("533005");

		boolean flag = addressDAO.update(address);

		assertEquals("createAddressTestCase", true, flag);

	}
@Ignore
	@Test
	public void listAllAddressTestCase() {
		int actualSize = addressDAO.list().size();
		assertEquals(2, actualSize);
	}

}
