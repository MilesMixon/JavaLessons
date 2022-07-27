package com.skillstorm.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.skillstorm.beans.Pokemon;

@Service
public class MessageListenerService {

	private static final Logger logger = LoggerFactory.getLogger(MessageListenerService.class);
	
	//tell it this message listens for a certain message
	@RabbitListener(queues = "${queues.oak}")
	public void listenForPokemon(@Payload Pokemon message) {
		logger.info(message + "! I choose you!");
	}
	
	@RabbitListener(queues = "${queues.fanout}")
	public void listenForDuplicates(@Payload Pokemon message) {
		logger.info("Fanout message recieved: " + message);
	}
}
