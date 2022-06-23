package com.skillstorm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.skillstorm.beans.Owner;
import com.skillstorm.data.OwnerDAO;

public class IntroJDBC {

	// JDBC: Java Database Connectivity, it's an API
	// the old way of connecting to databases
	// most modern frameworks for Java database connectivity build off of this
	
	// Very bad Practice
	// You do not want to hardcode these values 
	// fine for development, but not good for production
	// jdbc:mysql://host_name:port/schema_name (default mysql port is 3306)
	static final String connString = "jdbc:mysql://localhost:3306/zulmak";
	static final String username = "root";
	static final String password = "root";
	
	public static void main(String[] args) {
		//queryOwners();
		
		OwnerDAO dao = new OwnerDAO();
		
//		Owner newOwner = new Owner(0, "Marcie Lucia", "Green", "Sushi", 27);
//		
//		dao.addOwner(newOwner);
//		
//		System.out.println(dao.getAllOwners());
		
		//this is valid
		//this will return all the data in the table
		//not all sql injection attacks are dropping the table, could be me just accessing data that i should
		//not have access to
		//String name = "'Dan' UNION select * from owners;";
		String name = "'Dan' OR 1 = 1;"; //another way to return everything in the table
		dao.getByName(name);
		
		//System.out.println(dao.getById(3));
	}

	// you generally would not put your databse code in the same place as your main method
	public static void queryOwners() {
		//query for our list of owners. 
		/*
		 * 1. Load Driver
		 * 2. Make a connection object using driver manager
		 * 3. create a statement
		 * 4. execute the statement
		 * 5. close the connection
		 */
		try {
			// step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step 2
			Connection conn = DriverManager.getConnection(connString, username, password);
			// step 3
			Statement stmt = conn.createStatement();
			String sql = "Select * from owners;"; //will be sent to and compiled by the database
			//step 4
			//result set is just a representation of your table data
			ResultSet resp = stmt.executeQuery(sql);
			
			//very similar to an iterator, starts at null
			while(resp.next()) {
				System.out.println(resp.toString());
			}
			
			//step 5
			conn.close(); //this will never be done if an exceptions is thrown
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
