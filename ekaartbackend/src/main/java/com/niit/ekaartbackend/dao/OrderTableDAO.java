package com.niit.ekaartbackend.dao;

import java.util.List;

import com.niit.ekaartbackend.model.OrderTable;



public interface OrderTableDAO {
	
	public boolean save(OrderTable orderTable);
	public List<OrderTable> list(String userId);

}
