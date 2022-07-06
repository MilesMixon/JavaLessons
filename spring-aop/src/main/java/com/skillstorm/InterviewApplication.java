package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.skillstorm.beans.Interviewiee;
import com.skillstorm.beans.Interviewiee2;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy //enables AOP
public class InterviewApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(InterviewApplication.class);
		
		System.out.println(context.getBean(Interviewiee.class).interview() + "\n");
		//System.out.println(context.getBean(Interviewiee2.class).interview() + "\n");
		System.out.println(context.getBean(Interviewiee.class).interview("Software Developer") + "\n");
		System.out.println(context.getBean(Interviewiee.class).interview("Software Developer", 50000) + "\n");
		System.out.println(context.getBean(Interviewiee.class).interview(60000, "Software Developer") + "\n");
		System.out.println(context.getBean(Interviewiee.class).interview("Software Developer", "Microsoft") + "\n");
		System.out.println(context.getBean(Interviewiee.class).interview(70000) + "\n");
	}

}
