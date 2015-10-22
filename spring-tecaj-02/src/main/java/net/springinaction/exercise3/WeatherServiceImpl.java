package net.springinaction.exercise3;

import net.springinaction.exercise2.WeatherDao;
import net.springinaction.exercise2.WeatherException;


/**
 * @author domagoj
 *
 */
public class WeatherServiceImpl implements WeatherService {

	protected WeatherDao weatherDao;
	
	public String tomorrow (String place) {
		return "[" + place + "] Weather tomorrow: " + weatherDao.tomorrow(place);
	}

	public String today(String place) {
		return "[" + place + "] Weather today: " + weatherDao.today(place);
	}

	public String[] threeDays(String place) throws WeatherException {
		String[] forecast = null;

		forecast = weatherDao.threeDays(place);
		if (forecast == null) {
			throw new WeatherException("No data found for: " + place);
		}
		return forecast;
	}

	public void setForecast(WeatherData weatherData) {
		setToday(weatherData);
		setTomorrow(weatherData);
		setDayAfterTomorrow(weatherData);
	}

	public void setForecast2(WeatherData weatherData) {
	}
	
	protected void setTomorrow(WeatherData weatherData) {
		weatherDao.setForcast(weatherData.getPlace(), WeatherDao.TOMORROW, weatherData.getWeatherTomorrow());
	}
	
	protected void setToday(WeatherData weatherData) {
		weatherDao.setForcast(weatherData.getPlace(), WeatherDao.TODAY, weatherData.getWeatherToday());
	}

	/**
	 * Metoda za testiranje rada transakcije podrške.
	 * 
	 * @param weatherData
	 */
	protected void setDayAfterTomorrow(WeatherData weatherData) {
		throw new UnsupportedOperationException();
		//weatherDao.setForcast(weatherData.getPlace(), WeatherDao.TODAY_PLUS_2, weatherData.getWeatherDayAfterTomorrow());
	}
	
	//--- set / get methods ---------------------------------------------------
	
	public void setWeatherDao(WeatherDao weatherDao) {
		this.weatherDao = weatherDao;
	}

}
