package com.skillstorm.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	//all this will do is make out session factory
	
	//one class that makes/ uses our session for you and binds it to your current thread for you
	//session follows the facade design pattern
	//session per request
	
	//session factory has most of the functionality we need already
	//this is a practical application of a singleton, you only every want one 
	
	//sessions themselves are seperate (isolation) 
	//one session factory per database and multiple sessions
	private static final SessionFactory sessionFactory;
	
	static {
		//initalize our session factory
		
		// 0. grab your configuration properties
		//grab your config file
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		// 1. build your service registry
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		
		// 2. Pass it our configuration properties
		sb.applySettings(cfg.getProperties());
		
		// 3. we tell the service registry builder to return the registry it build for it
		StandardServiceRegistry standardServiceRegistry = sb.build();
		
		//we then tell the configuration about the registry
		// 4. build the session factory
		sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
	}
	
	public static final SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
