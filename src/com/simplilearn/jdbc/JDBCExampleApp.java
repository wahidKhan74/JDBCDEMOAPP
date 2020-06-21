package com.simplilearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExampleApp {

	static final String USERNAME ="sam";
	static final String PASSWORD ="sam121";
	
	static final String DB_URL ="jdbc:mysql://localhost:3306/testdb";	
	static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
	
	
	public static void main(String[] args) {
		
		Connection  conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			// 1. Register Driver
			System.out.println("Register Driver  + Get Connection");
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			
			
			// 3. connection
			System.out.println("Create Statement");
			stm = conn.createStatement();
			
			String query = "select * from employee";
			
			System.out.println("Execute query");
			
			rs = stm.executeQuery(query);
			
			
			while(rs.next()) {
				System.out.println("Employee Id: " + rs.getInt("empId"));
				System.out.println("Employee Name: " + rs.getString("empName"));
				System.out.println("Employee Dept: " + rs.getString("empDept"));
				System.out.println("===========================");
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
