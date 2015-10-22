package net.springinaction.exercise3;

import net.springinaction.exercise2.WeatherException;

public interface WeatherService {

	void setForecast(WeatherData weatherData);

	void setForecast2(WeatherData weatherData);
	
	String tomorrow (String place);
	String today(String place);
	String[] threeDays(String place) throws WeatherException;

}
