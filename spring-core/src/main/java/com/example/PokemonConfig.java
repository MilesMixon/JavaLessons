package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.skillstorm.ComicStoreConfig;
import com.skillstorm.ZeldaConfig;

@Configuration
//array of packages to look for components (spring beans) in
//will look for everything under this by default, or where you specify
@ComponentScan(basePackages = {"com.example.beans", "com.example.services"}) 
//have to tell spring about property files we want to use
//@PropertySource("classpath:trainer.properties") //classpath looks in src/main/resources
//if there are multiple files
//@PropertySources({
//	@PropertySource("classpath:trainer.properties"),
//	@PropertySource("classpath:ZeldaCongig.xml")
//}) //an array of annotations
//i can grab the build profile to change this, now i dont need to remember to change it
@PropertySource("classpath:pokemon-${spring.profiles.active}.properties") 
//to change this you go to run as -> run configurations -> arguments -> vm arguments
// then you type -D<whatever param>=<value> to set this
//maybe i also need multiple config files for different sets of beans
@Import({ ZeldaConfig.class, ComicStoreConfig.class })
public class PokemonConfig {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(PokemonConfig.class);
	}
}
