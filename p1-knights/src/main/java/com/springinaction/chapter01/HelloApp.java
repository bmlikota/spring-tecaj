package com.springinaction.chapter01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");

		GreetingService greetingService = (GreetingService) context.getBean("greetingService");

		greetingService.sayGreeting("Branko");

	}

}
