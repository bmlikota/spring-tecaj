package net.springinaction.exercise1;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.springinaction.exercise1.model.Genre;
import net.springinaction.exercise1.service.GenreService;
import net.springinaction.exercise1.service.ShowService;

public class TestDatasource {
	public static Logger log = LoggerFactory.getLogger(TestDatasource.class);
	
	@Autowired
	GenreService genreService;
	
	@Autowired
	ShowService showService;
	
	public TestDatasource() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-workshop-03/exercise-1/ticket-ctx.xml");
		AutowireCapableBeanFactory acbFactory = ctx.getAutowireCapableBeanFactory();
	    acbFactory.autowireBean(this);
	}
	
	public static void main(String[] args) {

		//Static workaround...
		TestDatasource test = new TestDatasource();

		// Simple JPA query
		
		List<Genre> genreList = test.genreService.findAll();
		log.info("Pronašao ukupno {} zapisa", genreList.size());
	}
}
