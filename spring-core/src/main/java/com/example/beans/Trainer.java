package com.example.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//this is a stereotype annotation
//allows spring to automatically search for and find this
@Component
public class Trainer implements InitializingBean {
	String name;
	int badges;
	String hatColor;
	
	//can use this to grab environment variabkes/ info from a property file
	@Autowired
	Environment env;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.name = env.getProperty("trainer.name");
		this.badges = Integer.parseInt(env.getProperty("trainer.badges"));
		this.hatColor = env.getProperty("trainer.hatColor");
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Trainer [name=" + name + ", badges=" + badges + ", hatColor=" + hatColor + "]";
	}
}
