package com.niit.ekaartbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekaartbackend.dao.ProductDAO;
import com.niit.ekaartbackend.model.Product;


public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		product = (Product)context.getBean("product");
		
	}
	@Ignore
	@Test
	public void createProductTestCase()
	{
		
		product.setId("Pro001");
		product.setCategory_id("cat001");
		product.setDescription("Apple mobile with good screen feature");
		product.setName("iphone 8 plus");
		product.setPrice(65000);
		product.setQuantity(1);
		product.setSupplier_id("Sup001");
		
		boolean flag =  productDAO.saveOrUpdate(product);

		assertEquals("createProductTestCase",true,flag);
		
	}
	@Ignore
	@Test
	public void updateProductTestCase()
	{
		product.setId("Pro008");
		product.setName("macbook air");
		product.setDescription("Apple laptop category");
		product.setCategory_id("Cat002");
		product.setPrice(75990);
		product.setSupplier_id("Sup001");
		product.setQuantity(20);
		boolean flag = productDAO.saveOrUpdate(product);
		assertEquals("update Product TestCase",true,flag);
	}
	@Ignore
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} 
}
