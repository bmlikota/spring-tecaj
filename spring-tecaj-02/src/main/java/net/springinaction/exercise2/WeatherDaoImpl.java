package net.springinaction.exercise2;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class WeatherDaoImpl extends JdbcDaoSupport implements WeatherDao {

	public static Logger log = LoggerFactory.getLogger(WeatherDaoImpl.class);
	
	private static final String FIND_BY_ID_SQL = "select forecast FROM weather_forecast WHERE id= ? AND place= ?";
	private static final String FIND_3_DAY_FORECAST = "select forecast FROM weather_forecast WHERE place= ?";
	
	public String forDate(String place, int day) {
		try {
			Object[] parameters = new Object[] {new Integer(day), place};
			String forecast = (String) getJdbcTemplate().queryForObject(FIND_BY_ID_SQL, parameters, String.class);

			return forecast;
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	public String[] threeDays(String place) {
		List dbresult = getJdbcTemplate().queryForList(FIND_3_DAY_FORECAST, new Object[] {place});
		log.debug("DB returned:"  + dbresult);	
		if (dbresult.size() == 0) {
			//unavailable data
			return null;
		}
		
		String[] result = new String[3];
		for (int i=0; i<dbresult.size(); i++) {
			Map map = (Map) dbresult.get(i);
			result[i] = (String) map.get("FORECAST");
		};
		return result;
	}

	public int setForcast(String place, int day, String forecast) {
		String dbforecast = forDate(place, day);
		log.debug("Found: " + dbforecast);
		if (dbforecast != null) {
			update(place, day, forecast);
		} else {
			insert(place, day, forecast);
		}
		return 1;
	}

	public String today(String place) {
		return forDate(place, WeatherDao.TODAY);
	}

	public String tomorrow(String place) {
		return forDate(place, WeatherDao.TOMORROW);
	}

	private int insert(String place, int day, String forecast) {
		log.debug("Performing insert..." + day + " >> " + place + ": " + forecast);
		return getJdbcTemplate().update("INSERT INTO weather_forecast (id, place, forecast) VALUES (?, ?, ?)", new Object[] {new Integer(day), place, forecast});
	}

	private int update(String place, int day, String forecast) {
		log.debug("Performing update..." + day + " >> " + place + ": " + forecast);
		return getJdbcTemplate().update("UPDATE weather_forecast SET forecast=? WHERE id=? AND place= ?", new Object[] {forecast, new Integer(day), place});
	}

}
