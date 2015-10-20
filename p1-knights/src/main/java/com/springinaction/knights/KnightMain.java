package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Knights main executable java class.
 * 
 * @author domagoj
 *
 */
public class KnightMain {
	public static void main(String[] args) {

		// Knight knight = new DamselRescuingKnight();
		// knight.embarkOnQuest();

		ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
		((AbstractApplicationContext) context).registerShutdownHook();

		Knight knight = (Knight) context.getBean("knight");
		// Knight tristan = (Knight) context.getBean("tristan");
		// Knight valiant = (Knight) context.getBean("valiant");
		// Knight ludiPero = (Knight) context.getBean("ludiPero");

		knight.embarkOnQuest();
		// tristan.embarkOnQuest();
		// valiant.embarkOnQuest();
		// ludiPero.embarkOnQuest();

	}
}
