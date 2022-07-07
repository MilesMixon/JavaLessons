package com.skillstorm.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.skillstorm.beans.Owner;
import com.skillstorm.mappers.OwnerRowCallbackHandler;
import com.skillstorm.mappers.OwnerRowMapper;

@Component
public class OwnerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParamTemplate;
	
	@Autowired
	OwnerRowMapper ownerMapper;
	
	@Autowired
	ApplicationContext context; //spring can find this for me
	
//	@Autowired
//	DataSource datasource;
	
	public void findAll() {
		//still have to define our queries for the jdbc template
		String sql = "select * from owners";
		//still cannot map for you, but can give it a lambda/ a RowMapper to map it for you
//		List<Owner> owners = jdbcTemplate.query(sql, (rs, rowNum) -> {
//								//System.out.println("row: " + rowNum);
//								return new Owner(rs.getInt("id"), 
//											     rs.getString("name"), 
//											     rs.getString("favoriteColor"), 
//											     rs.getString("favoriteFood"), 
//											     rs.getInt("age"));
//							});
		List<Owner> owners = jdbcTemplate.query(sql, ownerMapper);
		
		System.out.println(owners);
	}
	
	public void findById(int id) {
		//still going to parameterize our queries
		String sql = "select * from owners where id = ?";
		
		//maybe I want to do a one liner
		//cant do a one liner like this, need a way to map the columns
		//Owner result = jdbcTemplate.queryForObject(sql, Owner.class, new Object[] {id});
		Owner result = jdbcTemplate.queryForObject(sql, ownerMapper, new Object[] {id});
		
		//parameterized query by default
		//will throw an exception if the row isnt found
//		Owner result = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> { 
//							//what jdbc template uses to map the returns to an object
//							return new Owner(rs.getInt("id"), 
//								     rs.getString("name"), 
//								     rs.getString("favoriteColor"), 
//								     rs.getString("favoriteFood"), 
//								     rs.getInt("age"));
//						}, 
//						//what jdbc template uses to input your parameters
//						//applies them in the order they are listed
//						new Object[] { id });
		
		System.out.println(result);
	}
	
	public void createOwner(Owner owner) {
		String sql = "INSERT INTO owners (name, favoriteColor, favoriteFood, age) VALUES (?, ?, ?, ?)";
		//assigns the values in the order they are listed
		//update is used for insert, update, and delete queries
		jdbcTemplate.update(sql, new Object[] {
			owner.getName(),
			owner.getFavoriteColor(),
			owner.getFavoriteFood(),
			owner.getAge()
		});
	}
	
	//what if i dont want to worry about the order above?
	public void createOwnerNoQuestionMarks(Owner owner) {
		//same as our normal jdbc template but for use with named parameters
		//so more hibernate-like syntax there
		String sql = "INSERT INTO owners (name, favoriteColor, favoriteFood, age) VALUES (:name, :color, :food, :age)";
		
		//can use either a map or sqlParameterSource
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", owner.getName());
		params.addValue("color", owner.getFavoriteColor());
		params.addValue("food", owner.getFavoriteFood());
		params.addValue("age", owner.getAge());
		
		namedParamTemplate.update(sql, params);
	}
	
	public void findBlues() {
		//it is prototype, so this is now thread safe due to the loacl scope
		OwnerRowCallbackHandler rch = this.context.getBean(OwnerRowCallbackHandler.class);
		jdbcTemplate.query("select * from owners", rch);
		
		List<Owner> results = rch.getBlues();
		System.out.println(results);
	}
	
	public void countRows() {
		String sql = "select count(*) from owners";
		//query for object because we want a single result
		Integer rows = jdbcTemplate.queryForObject(sql, Integer.class); //uses a resultset extractor to grab this
		System.out.println("rows: " + rows);
	}
}
