package com.niit.ekaartbackend.dao;
import java.util.List;

import com.niit.ekaartbackend.model.User;

public interface UserDAO {
	
	public  boolean save(User user);
	
	
	public boolean update(User user);
	
	
	public boolean validate(String id, String password);
	
	
	
	public List<User> list();
	
	
	
	public User get(String id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
