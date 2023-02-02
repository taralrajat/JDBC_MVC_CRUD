package com.cjc.crudapp.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnectivity {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/LoginAndRegisterAppUsingJdbc";
	private static final String USER ="root";
	private static final String PASSWORD = "root";
	private static Connection con = null;
	private static PreparedStatement ps = null;
	
	public static PreparedStatement getStatment(String sql)
	{
	
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USER,PASSWORD);
			ps=con.prepareStatement(sql);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	
	public static void close()
	{
		try {
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}