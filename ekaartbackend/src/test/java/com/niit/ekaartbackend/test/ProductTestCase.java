package com.niit.ekaartbackend.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekaartbackend.dao.ProductDAO;
import com.niit.ekaartbackend.model.Product;


public class ProductTestCase {
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@Autowired
	private static Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		//scan the complete package and check for annoations like
		//@Component, @Controller, @Repository, @Service
		context.scan("com.niit"); 
		//clear the context(bean factory, and recreate all the
		//instances of the classes which are there in com.niit
		//with proper annotations.
		context.refresh();
		//ask the context to get instance of ProductDAO
		productDAO = (ProductDAO)context.getBean("productDAO");
		product = (Product)context.getBean("product");
	}
	//@Ignore
	@Test
	public void saveProductTestCase()
	{
		product = new Product();
		product.setId("Pro005");
		product.setName("smooth");
		product.setDescription("This is a nike product with touch screen display and bluetooth connectivity");
		product.setCategoryId("wat001");
		product.setSupplierId("Sup003");
		product.setPrice(10000);
		product.setQuantity(25);
		
	  boolean status = 	productDAO.save(product);
	  
	  assertEquals("save product test case", true, status);
	}
	
	@Ignore
	@Test
	public void updateProductTestCase()
	{
		product.setId("Pro002");
		product.setName("hp-- product");
		product.setDescription("This is hp product");
		product.setSupplierId("Sup002");
		product.setPrice(45000);
		product.setCategoryId("lap001");
		
		boolean status = productDAO.update(product);
		assertEquals("update test case", true,status );
	}
	@Ignore
	@Test
	public void getProductSuccessTestCase()
	{
		
	product= productDAO.get("Lenevo-001");
	
	assertNotNull("get product test case", product);
	}
	@Ignore
	@Test
	public void getProductFailureTestCase()
	{
		
	product= productDAO.get("Lenevo-001");
	
	assertNull("get product test case", product);
	}
	@Ignore
	@Test
	public void deleteProductSuccessTestCase()
	{
	boolean status =	productDAO.delete("Pro001");
	assertEquals("delete product succss test case" , true, status);
	
	}
	@Ignore
	@Test
	public void deleteProductFailureTestCase()
	{
	boolean status =	productDAO.delete("Lenevo-001");
	assertEquals("delete product failure test case" , false, status);
	
	}
	
	@Ignore
	@Test
	public void getAllProductsTestCase()
	{
	List<Product>	products = productDAO.list();
	
	assertEquals("get all products " , 3, products.size() );
	
	}
	
}
