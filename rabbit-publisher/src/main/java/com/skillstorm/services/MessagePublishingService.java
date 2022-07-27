package com.skillstorm.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagePublishingService {

	private static final Logger logger = LoggerFactory.getLogger(MessagePublishingService.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue queue;
	
	public void sendPokemon(String pokemon) {
		rabbitTemplate.convertAndSend(queue.getName(), pokemon);
		logger.info("Message Sent!");
	}
}
