package com.skillstorm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.skillstorm.beans.Link;
import com.skillstorm.processors.ZeldaBeanFactoryPostProcessor;
import com.skillstorm.processors.ZeldaBeanPostProcessor;

@Configuration
public class ZeldaConfig {

	@Bean(initMethod = "init", destroyMethod = "dispose")
	public Link link() {
		return new Link();
	}
	
	@Bean
	public ZeldaBeanPostProcessor postProcessor() {
		return new ZeldaBeanPostProcessor();
	}
	
	@Bean
	public ZeldaBeanFactoryPostProcessor beanFactoryPostProcessor() {
		return new ZeldaBeanFactoryPostProcessor();
	}
}
