package net.springinaction.exercise2.dao;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import net.springinaction.exercise2.WeatherDao;
import net.springinaction.exercise2.WeatherException;

//this should be integration test

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-workshop-02/test-context.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("/spring-workshop-02/dbunit/weather-data.xml")
public class MyWeatherDaoDbTest {

	@Autowired
	WeatherDao weatherDao;

	@Test
	public void forDate_whenRecordIsFound() {

		String forecast = weatherDao.forDate("Zagreb", WeatherDao.TOMORROW);

		//assert ...
		assertThat(forecast).isNotNull();
		assertThat(forecast).isEqualTo("Jako suncano");

	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void forDate_whenRecordIsNotFound() {
		weatherDao.forDate("NePostojeciGrad", 1);
	}

	@Test
	public void threeDays() throws WeatherException {

		String[] forecastArr = weatherDao.threeDays("Zagreb");

		assertThat(forecastArr).isNotNull();
		assertThat(forecastArr[WeatherDao.TODAY]).isEqualTo("Suncano");
		assertThat(forecastArr[WeatherDao.TOMORROW]).isEqualTo("Jako suncano");
		assertThat(forecastArr[WeatherDao.TODAY_PLUS_2]).isEqualTo("Jako jako suncano");

	}

	@Test
	public void today_whenRecordIsFound() {

		String forecast = weatherDao.today("Zagreb");

		assertThat(forecast).isNotNull();
		assertThat(forecast).isEqualTo("Suncano");

	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void today_whenRecordIsNoFound() {

		weatherDao.today("NePostojeciGrad");

	}

	@Test
	public void tomorrow_whenRecordIsFound() {

		String forecast = weatherDao.tomorrow("Zagreb");

		assertThat(forecast).isNotNull();
		assertThat(forecast).isEqualTo("Jako suncano");

	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void tomorrow_whenRecordIsNoFound() {

		weatherDao.tomorrow("NePostojeciGrad");

	}

	@Test
	public void setForcast_forNewPlace() {

		String place = "Amazona";
		int day = WeatherDao.TODAY;
		String forecast = "Kišetina";

		int rowNum = weatherDao.setForcast(place, day, forecast);
		String insertedForecast = weatherDao.forDate(place, day);

		assertThat(rowNum).isEqualTo(1);
		assertThat(insertedForecast).isNotNull();
		assertThat(insertedForecast).isEqualTo(forecast);

	}


	@Test(expected = DuplicateKeyException.class)
	public void setForcast_forExistingPlace() {

		String place = "Zagreb";
		int day = WeatherDao.TODAY;
		String forecast = "Kišetina";

		weatherDao.setForcast(place, day, forecast);

	}

}
