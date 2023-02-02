package com.cjc.crudapp.app.servicei;

import java.util.List;

import com.cjc.crudapp.app.model.User;

public interface ServiceI {
	
	public void saveUser(User u);
	public List<User> getAllUser();
	public List<User> loginUser(String username, String password);
	

}
