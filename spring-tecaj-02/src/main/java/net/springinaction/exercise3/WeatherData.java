package net.springinaction.exercise3;

import java.io.Serializable;

public class WeatherData implements Serializable {

	String place;
	String weatherToday;
	String weatherTomorrow;
	String weatherDayAfterTomorrow;

	public WeatherData(String place, String weatherToday, String weatherTomorrow, String weatherDayAfterTomorrow) {
		this.place = place;
		this.weatherToday= weatherToday;
		this.weatherTomorrow = weatherTomorrow;
		this.weatherDayAfterTomorrow = weatherDayAfterTomorrow;
	}

	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getWeatherDayAfterTomorrow() {
		return weatherDayAfterTomorrow;
	}
	public void setWeatherDayAfterTomorrow(String weatherDayAfterTomorrow) {
		this.weatherDayAfterTomorrow = weatherDayAfterTomorrow;
	}
	public String getWeatherToday() {
		return weatherToday;
	}
	public void setWeatherToday(String weatherToday) {
		this.weatherToday = weatherToday;
	}
	public String getWeatherTomorrow() {
		return weatherTomorrow;
	}
	public void setWeatherTomorrow(String weatherTomorrow) {
		this.weatherTomorrow = weatherTomorrow;
	}

}
