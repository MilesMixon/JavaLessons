package com.example.services;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//this is a bean, but its more a special bean. not going to be used in the same way
//as a trainer/ pokemon
//@Component
@Service //still a bean/ component. perform some action without state
//this annotation just makes it a bit more clear to developers what the intention of this class is
public class BattleSystem implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Battle System");
	}

}
