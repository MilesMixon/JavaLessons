package com.skillstorm.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.skillstorm.beans.Pokemon;

@Service
public class MessagePublishingService {

	private static final Logger logger = LoggerFactory.getLogger(MessagePublishingService.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${exchanges.fanout}")
	private String fanoutExchange;
	
	@Autowired
	private Queue queue;
	
	public void actionReplay(Pokemon pokemon) {
		//if we needed an key we would provide that
		rabbitTemplate.convertAndSend(fanoutExchange, "", pokemon);
		logger.info(pokemon + " duplicated!");
	}
	
	public void sendPokemon(String pokemon) {
		rabbitTemplate.convertAndSend(queue.getName(), pokemon);
		logger.info("Message Sent!");
	}
	
	public void tradePokemon(Pokemon pokemon) {
		rabbitTemplate.convertAndSend(queue.getName(), pokemon);
		logger.info("Traded: " + pokemon);
	}
}
