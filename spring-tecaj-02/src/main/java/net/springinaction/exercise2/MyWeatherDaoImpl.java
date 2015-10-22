package net.springinaction.exercise2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class MyWeatherDaoImpl extends NamedParameterJdbcDaoSupport implements WeatherDao {
	public String forDate(String place, int day) {
		String sql = "SELECT forecast FROM weather_forecast WHERE id = :id AND place = :place";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", day);
		params.put("place", place);

		String forecast = getNamedParameterJdbcTemplate().queryForObject(sql, params, String.class);

		return forecast;

	}

	public int setForcast(String place, int day, String forecast) {
		String sql = "INSERT INTO weather_forecast (id, place, forecast) VALUES (:id, :place, :forecast)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("place", place);
		params.put("id", day);
		params.put("forecast", forecast);

		int ret = getNamedParameterJdbcTemplate().update(sql, params);

		return ret;
	}

	public String[] threeDays(String place) throws WeatherException {
		String[] forecastArr = new String[3];

		forecastArr[WeatherDao.TODAY] = forDate(place, WeatherDao.TODAY);
		forecastArr[WeatherDao.TOMORROW] = forDate(place, WeatherDao.TOMORROW);
		forecastArr[WeatherDao.TODAY_PLUS_2] = forDate(place, WeatherDao.TODAY_PLUS_2);

		return forecastArr;
	}

	public String today(String place) {
		return forDate(place, WeatherDao.TODAY);
	}

	public String tomorrow(String place) {
		return forDate(place, WeatherDao.TOMORROW);
	}
}
