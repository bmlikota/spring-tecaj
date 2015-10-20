package net.springinaction.exercise2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class WeatherDaoImpl extends JdbcDaoSupport implements WeatherDao {

	public String forDate(String place, int day) {
		// TODO Auto-generated method stub
		return null;
	}

	public int setForcast(String place, int day, String forecast) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String[] threeDays(String place) throws WeatherException {
		// TODO Auto-generated method stub
		return null;
	}

	public String today(String place) {
		// TODO Auto-generated method stub
		return null;
	}

	public String tomorrow(String place) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
