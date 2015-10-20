package com.springinaction.chapter01;
/**
 * The most simple implementation of the GretingService.
 * 
 * @author domagoj
 *
 */
public class GreetingServiceImpl implements GreetingService {

	private String greeting;

	public GreetingServiceImpl() {
	}

	public GreetingServiceImpl(final String greeting) {
		this.greeting = greeting;
	}

	public void sayGreeting(final String name) {
		System.out.println(greeting + " " + name + "!");
	}

	//--- set / get methods ---------------------------------------------------
	
	public void setGreeting(final String greeting) {
		this.greeting = greeting;
	}
}
