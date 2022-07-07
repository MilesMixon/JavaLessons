package com.skillstorm.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.skillstorm.beans.Owner;

//JDBC is not an ORM, so we still have to map things manually
//it does not map all at once it will iterate one row at a time and map it

//this class is used for the sole purpose of telling jdbc how to map our columns
//the idea behind row mappers is that these are stateless, so no instance variables
@Component //singleton by default
public class OwnerRowMapper implements RowMapper<Owner> {

	@Override
	public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
		//this function tells jdbc how to do your mapping
		//is exactly what our lambda function was
		//same as the lambda, will do this for every returned row
		return new Owner(rs.getInt("id"), 
					     rs.getString("name"), 
					     rs.getString("favoriteColor"), 
					     rs.getString("favoriteFood"), 
					     rs.getInt("age"));
	}

}
