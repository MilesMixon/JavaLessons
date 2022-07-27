package com.skillstorm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		service.sendPokemon("Blaziken");
		service.sendPokemon("Lopunny");
		service.sendPokemon("Mimikyu");
		service.sendPokemon("Umbreon");
	}

}
