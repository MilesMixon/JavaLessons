package com.skillstorm.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import com.skillstorm.beans.Owner;

//this is stateful
//it is used to extract/ hold the results vs the row mapper just maps them but does not hold them
@Component //we don't want it to be a singleton
@Scope("prototype") //will make a copy every time
public class OwnerRowCallbackHandler implements RowCallbackHandler {

	private List<Owner> blues = new ArrayList<>();

	@Override
	public void processRow(ResultSet rs) throws SQLException {
		//do some processing/ inspection of the rows
		Owner temp = new Owner(rs.getInt("id"), 
						       rs.getString("name"), 
							   rs.getString("favoriteColor"), 
							   rs.getString("favoriteFood"), 
							   rs.getInt("age"));
		
		String color = temp.getFavoriteColor();
		if (color.toLowerCase().contains("blue")) {
			temp.setName(temp.getName() + "-" + temp.getFavoriteColor());
			blues.add(temp);
		}
	}
	
	public List<Owner> getBlues() {
		//this returns a copy of the list I have, dont wont to change the original list
		return new ArrayList<>(blues);
	}
}


