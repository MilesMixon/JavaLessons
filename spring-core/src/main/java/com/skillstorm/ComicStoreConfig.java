package com.skillstorm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.skillstorm.beans.Marvel;

//instead of using xml we can use a class
// <beans> are defined here
@Configuration
public class ComicStoreConfig {

	@Bean
	public Marvel comic() {
		return new Marvel();
	}
}
