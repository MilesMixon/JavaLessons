package com.skillstorm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //have to tell it it's an aspect
@Component //still a bean
public class SecurityGuard {

	//uses annotations
	//uses the same annotations as JUnit
	
	//these work off of proxies. Spring creates a proxy of your code and routes calls
	//through that so that aspects can cut in as needed and pass those along. 
	
	//tells it that this should run before a certain method/ methods
	//the method your specify is a join point (a spot that an aspect can cut in)
	//also a point cut/ a spot i can cut in
	//@Before("execution(public boolean interview())")
	@Before("pointCutHook()")
	public void checkId() {
	//public void checkId(JoinPoint joinPoint) {
		//System.out.println("Calling method: " + joinPoint.getSignature());
		System.out.println("@Before check Id");
		System.out.println("They're on the list");
	}
	
	//@Before("execution(public boolean interview())")
	@Before("pointCutHook()")
	public void signIn() {
		System.out.println("Sign in");
	}
	
	//just runs afterwards
	//@After("execution(public boolean interview())")
	@After("pointCutHook()")
	public void signOut() {
		System.out.println("@After sign out");
		System.out.println("Have a nice day");
	}
	
	//for these two you have to bing the value you are passing in using the annotation
	//only runs after it returns a value successfully
	@AfterReturning(pointcut = "pointCutHook()", returning = "returnVal")
	public void thankYouNote(Object returnVal) {
		//can't change the returnVal, but can see what it is
		//returnVal = false;
		System.out.println("@After returning Thanks for your interview today! " + returnVal);
	}
	
	//after an exception is thrown/ after executing unsuccessfully
	@AfterThrowing(pointcut = "pointCutHook()", throwing = "t")
	public void ohNo(Throwable t) {
		System.out.println("@AfterThrowing late to the interview");
		//t.printStackTrace();
	}
	
	//want to avoid this annotation if possible
	//so you only want to use as much control as needed
	//can be used to control the order
	//does everything
	//@Around("pointCutHook()")
	public Object securityProcedure(ProceedingJoinPoint joinPoint) {
		
		//@Before
		checkId();
		
		System.out.println("Taking personal items");
		//@Before
		signIn();
		
		//the method itself
		Object returnVal = null;
		//can control when the method i was called around is executed
		try {
			returnVal = joinPoint.proceed();
			
			//@AfterReturning
			//more powerful, i can actually change the return Value
			//returnVal = false;
		} catch (Throwable e) {
			//@AfterThrowing
			e.printStackTrace();
		}
		
		//@After
		System.out.println("Returning personal items");
		
		//@After
		signOut();
		
		//give control back to spring for whatever it has to do next
		//returns the value from the method as is the advice never happened
		return returnVal;
	}
	
	//only advises what matches this expression
	//@Pointcut("execution(public boolean interview())")
	//any interview method that return a boolean and hav one param of any type
	//@Pointcut("execution(boolean interview(*))")           //access modifier unnecessary
	//@Pointcut("execution(* interview(*))")                 //any return type and one parameter of any type
	//@Pointcut("execution(* interview(int))")               //any return type, one int param
	//@Pointcut("execution(* interview(*, String))")         //any return, any first param, a String second param
	//@Pointcut("execution(* interview(..))")                //any number of parameters of any type
	//@Pointcut("execution(* interview(.., String))")        //can mic and match
	//@Pointcut("execution(* interview(int, ..))")
	@Pointcut("execution(* interview(..))")
	//@Pointcut("execution(* inter*(..))")                   //any method that starts with inter
	//@Pointcut("execution(* *(..))")                        //runs for everything
	//@Pointcut("within(com.skillstorm.beans.*)")            //only advises things inside of the beans package
	//@Pointcut("within(com.skillstorm.beans.Interviewiee)") //only within this class
	public void pointCutHook() {
		//can't control the order
		//but can use this to define a specific point to cut in and re-use that logic
	}
}
