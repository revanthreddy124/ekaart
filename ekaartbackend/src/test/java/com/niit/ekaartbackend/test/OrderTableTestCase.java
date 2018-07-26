package com.niit.ekaartbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekaartbackend.dao.OrderTableDAO;
import com.niit.ekaartbackend.model.OrderTable;



public class OrderTableTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static OrderTable orderTable;
	
	@Autowired
	static OrderTableDAO orderTableDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		orderTableDAO =  (OrderTableDAO) context.getBean("orderTableDAO");
		
		
		orderTable = (OrderTable)context.getBean("orderTable");
		
	}
	
	
	@Ignore
	@Test
	public void createOrderTableTestCase(){
		orderTable.setId(1);
		orderTable.setUser_id("seshagiri");
		orderTable.setStatus("Active");
		boolean flag = orderTableDAO.save(orderTable);
		assertEquals("createOrderTableTestCase", true, flag);
	}
	@Ignore
	@Test
	public void listTestCase(){
		int orderedSize = orderTableDAO.list("seshagiri").size();
		assertEquals(1, orderedSize);
	}

}
