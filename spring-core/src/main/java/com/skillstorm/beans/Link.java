package com.skillstorm.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//why the spring lifecycle?
//the point of Spring is that we can give Spring control over our Beans
//the lifecycle creates moments where we are able to jump back in and take back control from Spring
public class Link implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
	/*
	 * 1. instantiate the bean (uses constructor)
	 * 2. populate the properties (uses setters)
	 * 3. set the bean name (if it's a prototype and needs to copy itself)
	 * 4. BeanFactoryAware, it is made aware of the factory/ bean that made it
	 * 5. Application context aware
	 * 6. after properties set
	 * 7. custom init
	 * 8. destroy
	 * 9. custom destroy
	 */

	//need to follow best practices for the SPring lifecycle to work as intended
	//@Value("Hylian Shield") //skips your setters
	private String rightHand;
	//@Value("Master Sword")
	private String leftHand;
	
	private String beanName;
	
	public Link() {
		//calls this to instantiate the object, must be a no-args constructor
		System.out.println("Link Instantiated");
	}

	public String getRightHand() {
		return rightHand;
	}

	public void setRightHand(String rightHand) {
		//then it sets your properties using any setters
		System.out.println("Properties set");
		this.rightHand = rightHand;
	}

	public String getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(String leftHand) {
		//System.out.println("Left hand set");
		this.leftHand = leftHand;
	}

	//BeanNameAware
	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("BeanNameAware setBeanName: " + name); //gets the name from the app context
	}

	//BeanFactoryAware
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryAware setBeanFactory: " + beanFactory);
		//under the hood your bean factory and the context are the same
		//System.out.println(beanFactory.getBean(Link.class)); //same bean im currently creating
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware setApplicationContext: " + applicationContext);
		//System.out.println(applicationContext.getBean(Link.class)); //same bean
	}

	//InitializingBean
	// this is essentially your init method
	// it can be used to run logic after all instance variables (properties) are set
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean afterPropertiesSet");
	}
	
	//custom init method
	public void init() {
		System.out.println("custom init()");
	}
	
	//better for containers
	//before spring
	@PostConstruct
	public void postConstruct() {
		System.out.println("PostConstruct");
	}

	//DisposableBean
	//destroy method, any cleanup you have to do
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy()");
	}
	
	//custom destroy
	public void dispose() {
		System.out.println("Custom destroy()");
	}
	
	//better for containers
	//before spring
	@PreDestroy
	public void preDestroy() {
		System.out.println("PreDestroy");
	}
}
