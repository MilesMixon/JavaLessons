package com.skillstorm.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//separate from the bean being initialized
//actually is a bean
public class ZeldaBeanPostProcessor implements BeanPostProcessor {

	//two methods for post processing. don't need to override these, but can
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// before initialization
		//before "init" methods
		System.out.println("BeanPostProcessor postProcessBeforeInitialization");
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// after initialization
		// after "init" methods
		System.out.println("BeanPostProcessor postProcessAfterInitialization");
		return bean;
	}

}
