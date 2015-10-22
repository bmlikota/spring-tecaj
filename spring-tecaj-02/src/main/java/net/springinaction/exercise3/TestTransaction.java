package net.springinaction.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import net.springinaction.exercise2.WeatherException;

public class TestTransaction {

	public static Logger log = LoggerFactory.getLogger(TestTransaction.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String place = "SPLIT";
		WeatherData data = new WeatherData(place, "Suncano", "Oblacno", "Promjenjivo");

		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("spring-workshop-02/exercise-3/transaction-ctx.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-workshop-02/exercise-3/transaction-3-ctx.xml");

		 WeatherService service = (WeatherService) ctx.getBean("weatherService");
		// WeatherService service = (WeatherService)
		// ctx.getBean("weatherServiceTs");

		try {
			service.setForecast(data);
			log.info("DONE -> setForecast");
		} catch (Exception ex) {
			log.error("FAILED -> Caught Exception:" + ex);
		}

		// check the database
		try {
			String[] forecast = service.threeDays(place);
			log.info("Forecast found for {}: {} / {} / {}", new Object[] { place, forecast[0], forecast[1], forecast[2] });
		} catch (WeatherException ex) {
			log.info("----> No Forecast found for {}", place);
		}

	}

}
