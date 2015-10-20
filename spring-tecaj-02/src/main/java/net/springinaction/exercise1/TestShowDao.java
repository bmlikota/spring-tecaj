package net.springinaction.exercise1;

import java.util.List;

import net.springinaction.exercise1.dao.GenreDao;
import net.springinaction.exercise1.dao.ShowDao;
import net.springinaction.exercise1.model.Genre;
import net.springinaction.exercise1.model.Show;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestShowDao {

	public static Logger log = LoggerFactory.getLogger(TestShowDao.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-workshop-02/exercise-1/ticket-ctx.xml");
		
		ShowDao showDao = (ShowDao) ctx.getBean("showDao");

		GenreDao genreDao = (GenreDao) ctx.getBean("genreDao");
		Genre genre = genreDao.findById(new Long(1));

		// 1. list all shows
		List<Show> result = showDao.findAll();
		log.info("result=" + result);

		// 2. create new show
		Show show = new Show();
			
		show.setName("Dummy show");
		show.setGenre(genre);
		show.setSeatingPlanId(1);
		
		showDao.create(show);
		log.info("Show created!");
		
		// 3. find existing show
		// SET me before execution!!!
		long existingShowId = 2;
		show = showDao.findById(existingShowId);
		log.info("findByID (" + existingShowId + ") >> " + show);
		
		// 4. update existing show
		show.setName("Dummy Show " + System.currentTimeMillis());
		showDao.update(show);
		show.setSeatingPlanId(3);
		
		// 5. retrive updated show
		show = showDao.findById(existingShowId);
		log.info("After update (" + existingShowId + ") >> " + show);
		
	}
}
