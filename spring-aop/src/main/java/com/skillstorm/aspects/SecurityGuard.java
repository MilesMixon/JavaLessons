package com.skillstorm.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //have to tell it it's an aspect
@Component //still a bean
public class SecurityGuard {

	//uses annotations
	//uses the same annotations as JUnit
	
	//tells it that this should run before a certain method/ methods
	//the method your specify is a join point (a spot that an aspect can cut in)
	//also a point cut/ a spot i can cut in
	//@Before("execution(public boolean interview())")
	@Before("pointCutHook()")
	public void checkId() {
		System.out.println("@Before check Id");
		System.out.println("They're on the list");
	}
	
	//@Before("execution(public boolean interview())")
	@Before("pointCutHook()")
	public void signIn() {
		System.out.println("Sign in");
	}
	
	//@After("execution(public boolean interview())")
	@After("pointCutHook()")
	public void signOut() {
		System.out.println("@After sign out");
		System.out.println("Have a nice day");
	}
	
	//only advises what matches this expression
	//@Pointcut("execution(public boolean interview())")
	//any interview method that return a boolean and hav one param of any type
	//@Pointcut("execution(boolean interview(*))")     //access modifier unnecessary
	//@Pointcut("execution(* interview(*))")           //any return type and one parameter of any type
	//@Pointcut("execution(* interview(int))")         //any return type, one int param
	//@Pointcut("execution(* interview(*, String))")   //any return, any first param, a String second param
	//@Pointcut("execution(* interview(..))")          //any number of parameters of any type
	//@Pointcut("execution(* interview(.., String))")  //can mic and match
	//@Pointcut("execution(* interview(int, ..))")
	@Pointcut("execution(* interview(..))")
	public void pointCutHook() {
		//can't control the order
		//but can use this to define a specific point to cut in and re-use that logic
	}
}
