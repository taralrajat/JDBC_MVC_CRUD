package com.cjc.crudapp.app.daoiimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cjc.crudapp.app.dao.Daoi;
import com.cjc.crudapp.app.model.User;
import com.cjc.crudapp.app.util.JDBCConnectivity;

public class Daoimpl implements Daoi{
	
	
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
			// TODO Auto-generated catch block
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
	
	public void deleteUser(int id) {
		String deleteUser = "delete from user where id=?";
		PreparedStatement ps = JDBCConnectivity.getStatment(deleteUser);
		try {
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void updateUser(User u) {
		String updateUser = "update user set name=?, username=?,  password=? where id=?";
		PreparedStatement ps = JDBCConnectivity.getStatment(updateUser);
		try {
			ps.setString(1, u.getName());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setInt(4, u.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User edit(int id) {
		String selectSingleUser = "select* from user where id=?";
		PreparedStatement ps = JDBCConnectivity.getStatment(selectSingleUser);
		
		User u = null;
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
		
		
		
	}

}
