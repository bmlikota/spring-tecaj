package net.springinaction.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WeatherApp {

	public static Logger log = LoggerFactory.getLogger(WeatherApp.class);
	/**
	 * Tests WeatherDao
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-workshop-02/exercise-2/weatherdao-ctx.xml");
		WeatherDao weatherDao = (WeatherDao) ctx.getBean("weatherDao");
		
		try {
			log.info("Prognoza za Zagreb za danas: " + weatherDao.today("ZAGREB"));
			log.info("Prognoza za ZAGREB naredna 3 dana=" + weatherDao.threeDays("ZAGREB"));
			
			//TODO: testovi za setForcast() i forDate()
			
		} catch (WeatherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
