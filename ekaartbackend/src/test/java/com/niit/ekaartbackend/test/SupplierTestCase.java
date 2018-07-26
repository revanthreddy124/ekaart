package com.niit.ekaartbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekaartbackend.dao.SupplierDAO;
import com.niit.ekaartbackend.model.Supplier;


public class SupplierTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		
		supplier = (Supplier) context.getBean("supplier");

	}
	@Ignore
	@Test
	public void createSupplierTestCase() {
		supplier.setId("Sup001");
		supplier.setName("dhoni");
		supplier.setAddress("green hills,kothapet,hyderabad,telangana");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);

	}
	@Ignore
	@Test
	public void updateSupplierTestCase() {
		supplier.setId("Sup001");
		supplier.setName("dhoni");
		supplier.setAddress("teachers colony,dilsukhnagar,hyderabad,telangana");

		boolean flag = supplierDAO.update(supplier);

		assertEquals("updateSupplierTestCase", true, flag);

	}
	@Ignore
	@Test
	public void listAllSupplierTestCase() {
		int actualSize = supplierDAO.list().size();
		assertEquals(6, actualSize);
	}

}
