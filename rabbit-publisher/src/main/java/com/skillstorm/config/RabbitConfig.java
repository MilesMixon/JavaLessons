package com.skillstorm.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	//pokemon
	@Value("${queues.oak}")
	private String queueName;
	
	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}
}
