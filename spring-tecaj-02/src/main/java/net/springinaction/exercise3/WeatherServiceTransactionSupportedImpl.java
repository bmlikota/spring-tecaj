package net.springinaction.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
/**
 * Primjer implementacije WeatherServiceImpl sa ugrađenom programskom podrškom za transakcije.
 * 
 * @author domagoj
 *
 */
public class WeatherServiceTransactionSupportedImpl extends WeatherServiceImpl {

	public static Logger log = LoggerFactory.getLogger(WeatherServiceTransactionSupportedImpl.class);
	
	private TransactionTemplate transactionTemplate;

	public void setForecast(final WeatherData weatherData) {
		
		transactionTemplate.execute(
			new TransactionCallback() {
				public Object doInTransaction(TransactionStatus ts) {
					try {
						setToday(weatherData);
						setTomorrow(weatherData);
						setDayAfterTomorrow(weatherData);
						
					} catch(Exception ex) {
						log.info("Exception caught! >> rolling back. " + ex);
						ts.setRollbackOnly();
					}
					return null;
				}
			}
		);
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
}
