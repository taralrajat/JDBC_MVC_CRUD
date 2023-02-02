package com.cjc.crudapp.app.dao;

import java.util.List;

import com.cjc.crudapp.app.model.User;

public interface Daoi {
	
	public void saveUser(User u);
	public List<User> getAllUser();
	public void deleteUser(int id);
	public void updateUser(User u);
	public User edit(int id);
}
