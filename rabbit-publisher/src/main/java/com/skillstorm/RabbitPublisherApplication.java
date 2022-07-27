package com.skillstorm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skillstorm.beans.Pokemon;
import com.skillstorm.services.MessagePublishingService;

@SpringBootApplication
public class RabbitPublisherApplication implements CommandLineRunner {
	
	@Autowired
	private MessagePublishingService service;

	public static void main(String[] args) {
		SpringApplication.run(RabbitPublisherApplication.class, args);
	}

	//so i can easily send these commands
	@Override
	public void run(String... args) throws Exception {
//		service.sendPokemon("Empoleon");
//		service.sendPokemon("Ditto");
//		service.sendPokemon("Nidoqueen");
//		service.sendPokemon("Lapras");
	
//		service.tradePokemon(new Pokemon("Blaziken", "Fire"));
//		service.tradePokemon(new Pokemon("Mimikyu", "Ghost"));
//		service.tradePokemon(new Pokemon("Hitmonchan", "Fighting"));
//		service.tradePokemon(new Pokemon("Empoleon", "Water"));
		
		service.actionReplay(new Pokemon("Ditto", "Normal"));
		service.actionReplay(new Pokemon("Banette", "Ghost"));
		service.actionReplay(new Pokemon("Weedle", "Bug"));
		service.actionReplay(new Pokemon("Staraptor", "Flying"));
	}

}
