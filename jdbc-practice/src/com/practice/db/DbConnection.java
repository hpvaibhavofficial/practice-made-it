package com.practice.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DbConnection {
	
	public static Connection getConnetion() throws SQLException{
			MysqlDataSource ds = new  MysqlDataSource();
			ds.setUser("root");
			ds.setPassword("vvvvvvvv");
			ds.setUrl("jdbc:mysql://localhost:3306/lpu25");
			Connection conn = ds.getConnection();
			
		return conn;
	}

	
	public static void main(String[] args) {
		try {
			
		}
		catch(Exception e) {
			
		}
		finally
		{
			
		}
	}

}
