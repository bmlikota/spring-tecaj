package com.springinaction.chapter01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello World App - Spring way.
 * 
 */
public class HelloSpringApp {
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");

		GreetingService greetingService = (GreetingService) context.getBean("greetingService");

		greetingService.sayGreeting("Domagoj");
	}
}
