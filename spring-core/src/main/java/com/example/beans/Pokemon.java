package com.example.beans;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//maybe im not ready to ship this, and only want it to exist in development
//i can tell spring not to create this bean outside of development
@Profile("dev")
//can use basic boolean logic with this !, |, &
// also works on things i annotate with @Bean
/* 
 * Feature Flagging: enable/ disable features programmatically
 * 					- at runtime turn functionality on or off
 * 					- can just shut off a feature that isnt working
 * 
 * 		Using a spring profile isnt that dynamic though, involves me recompiling
 */
public class Pokemon implements InitializingBean {

	//looks for a property called "trainer.name" in my property file
	@Value("${trainer.name}") //can also use this to grab info from the environment
	String trainerName;
	
	@Value("#{systemProperties['java.version']}") //can grab info from the JVM too
	String type;
	
	//probably would not hardcode it like this, but you can
	@Value("#{ {'CurrentHp': 1000, 'MaxHp': 1500} }")
	Map<String, Integer> hp;
	
	//the $ is usually for property files, but says that there is some value somewhere
	//on the system with that name
	//the # allows you do do more powerful things
	//@Value("${NUMBER_OF_PROCESSORS}")
	@Value("#{systemEnvironment['NUMBER_OF_PROCESSORS']}") //two ways to do this
	int spd;
	
	@Value("#{ T(java.lang.Math).random()}") //only for static methods
	double atk;
	
	@Value("#{ T(java.lang.Math).random()}") //only for static methods
	double def;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Pokemon [trainer=" + trainerName + ", type=" + type + ", hp=" + hp + ", spd=" + spd + ", atk=" + atk
				+ ", def=" + def + "]";
	}
}
