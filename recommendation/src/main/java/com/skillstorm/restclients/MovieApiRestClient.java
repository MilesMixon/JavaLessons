package com.skillstorm.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.skillstorm.models.Movie;

//feign clients give us an easy way to make a declarative rest client
// 		-- the spring data jpa of rest clients
//		-- only works through eureka
@Component
@FeignClient(path = "/movies/v1", name = "MOVIE-API") //tells it this is a feign client
public interface MovieApiRestClient {

	@GetMapping
	public Movie[] findAll();
	
	@GetMapping("/movie/{id}")
	public Movie findById(@PathVariable int id);
}
