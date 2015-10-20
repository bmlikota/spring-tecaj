package net.springinaction.exercise2;

/**
 * Legacy WeatherForecast dao definition.
 * 
 * @author dmadunic
 *
 */
public interface WeatherDao {

	public final static int TODAY = 0;
	public final static int TOMORROW = 1;
	public final static int TODAY_PLUS_2 = 2;

	/**
	 * Returns weather forecast for place for today.
	 * 
	 * @param place
	 * @return
	 */
	String today(String place);
	
	/**
	 * Returns weather forecast for place for tomorrow.
	 * 
	 * @param place
	 * @return
	 */
	String tomorrow(String place);
	
	/**
	 * Returns weather forecast for place for specific day (0 - today, 1 - tomorrow, 2 - day after tomorrow).
	 * 
	 * @param place
	 * @param day
	 * @return
	 */
	String forDate(String place, int day);

	/**
	 * Returns three day forecast for specified place.
	 * 
	 * @param place
	 * @return
	 * @throws WeatherException if no forecast exists.
	 */
	String[] threeDays(String place) throws WeatherException;
	
	/**
	 * Sets three day forecast for specific place.
	 * @param place
	 * @param day
	 * @param forecast
	 * @return
	 */
	int setForcast(String place, int day, String forecast);

}
