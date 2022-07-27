package com.skillstorm.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Value("${queues.oak}")
	private String queueName;
	
	@Value("${queues.fanout}")
	private String fanoutQueue;
	
	@Value("${exchanges.fanout}")
	private String fanoutExchange;
	
	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}
	
	@Bean
	public Queue fanoutQueue() {
		return new Queue(fanoutQueue);
	}
	
	@Bean
	public Exchange fanout() {
		return new FanoutExchange(fanoutExchange);
	}
	
	//want it to use the two beans we just setup
	@Bean
	public Binding bindQueueToTheFanoutExchange(FanoutExchange fanout, Queue fanoutQueue) {
		//we use a builder to build out binding/ connection between the queue and the exchange here
		return BindingBuilder.bind(fanoutQueue).to(fanout);
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
