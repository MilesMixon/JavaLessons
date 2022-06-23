package com.skillstorm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.beans.Owner;

// DAO: Data Access Object
// Repository: very similar to DAOs
public class OwnerDAO {
	// Very bad Practice
	// You do not want to hardcode these values 
	// fine for development, but not good for production
	// jdbc:mysql://host_name:port/schema_name (default mysql port is 3306)
	static final String connString = "jdbc:mysql://localhost:3306/zulmak";
	static final String username = "root";
	static final String password = "root";
	
	// static block will be run before i get to any of my methods
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Owner> getAllOwners() {
		List<Owner> owners = new LinkedList<>();
		
		try (Connection conn = DriverManager.getConnection(connString, username, password)) {
			Statement stmt = conn.createStatement();
			String sql = "Select * from owners;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Owner temp = new Owner(rs.getInt("id"), 
									   rs.getString("name"), 
									   rs.getString("favoriteColor"), 
									   rs.getString("favoriteFood"), 
									   rs.getInt("age"));
				owners.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return owners;
	}
	
	//accessing OwnerTable1
	public Owner getByName(String name) {
		Owner result = new Owner();
		
		try (Connection conn = DriverManager.getConnection(connString, username, password)) {
			Statement stmt = conn.createStatement();
			//SQL injection attacks
			// can happen when text is sent straight through like this
			String sql = "Select * from ownertable1 where name = " + name;
			boolean test = stmt.execute(sql);
			//rs.next();
//			result = new Owner(rs.getInt("id"), 
//							   rs.getString("name"), 
//							   rs.getString("favoriteColor"), 
//							   rs.getString("favoriteFood"), 
//							   rs.getInt("age"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Owner getById(int id) {
		//prepared statements were created to help combat sql injection attacks
		// pre-compile your sql so that nothing is compiles/ processed by the database
	    Owner result = new Owner();
	    
	    try (Connection conn = DriverManager.getConnection(connString, username, password)) {
	    	String sql = "Select * from owners where id = ?"; //syntax for a parameter in a statement
	    	PreparedStatement stmt = conn.prepareStatement(sql);
	    	stmt.setInt(1, id);
	    	ResultSet rs = stmt.executeQuery();
	    	rs.next();
	    	result = new Owner(rs.getInt("id"), 
							   rs.getString("name"), 
							   rs.getString("favoriteColor"), 
							   rs.getString("favoriteFood"), 
							   rs.getInt("age"));
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
	    
	    return result;
	}
	
	public Owner addOwner(Owner owner) {
		Owner result = owner;
		
		try (Connection conn = DriverManager.getConnection(connString, username, password)) {
//			String sql = "INSERT INTO owners (name, favoriteColor, favoriteFood, age) VALUES " 
//						+ "('" + owner.getName() + "', '" 
//						+ owner.getFavoriteColor() + "', '" 
//						+ owner.getFavoriteFood() + "', " 
//						+ owner.getAge() + ")";
			String sql = "INSERT INTO owners (name, favoriteColor, favoriteFood, age) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, owner.getName());
			stmt.setString(2, owner.getFavoriteColor());
			stmt.setString(3, owner.getFavoriteFood());
			stmt.setInt(4, owner.getAge());
			stmt.executeUpdate();
			
			//stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet keys = stmt.getGeneratedKeys();
			keys.next(); //still a result set, starts at null
			result.setId(keys.getInt(1)); //get the first returned column
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
