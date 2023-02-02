package com.cjc.crudapp.app.serviceiimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cjc.crudapp.app.model.User;
import com.cjc.crudapp.app.servicei.ServiceI;
import com.cjc.crudapp.app.util.JDBCConnectivity;


public class UserServiceiImpl implements ServiceI{

	@Override
	public void saveUser(User u) {
		String saveUser = "insert into user(name,username,password) values(?,?,?)";
		PreparedStatement ps = JDBCConnectivity.getStatment(saveUser);
		try {
			ps.setString(1, u.getName());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}			
	}

	@Override
	public List<User> getAllUser() {
		
		List<User> userList = new ArrayList<>();
		String getAllUser = "select * from user";
		PreparedStatement ps = JDBCConnectivity.getStatment(getAllUser);
		
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				userList.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public List<User> loginUser(String username, String password) {
		List<User> userList = new ArrayList<>();
		
		String getUser ="select* from user where username=? and password=?";
		PreparedStatement ps = JDBCConnectivity.getStatment(getUser);
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setUsername(rs.getString(3));
				u.setPassword(rs.getString(4));
				userList.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return userList;
	}

	

}
