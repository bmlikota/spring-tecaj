package net.springinaction.exercise2;
/**
 * Specific Weather Service Exception.
 * 
 * @author domagoj
 *
 */
public class WeatherException extends Exception {

    public WeatherException(String msg) {
    	super(msg);
    }

}
