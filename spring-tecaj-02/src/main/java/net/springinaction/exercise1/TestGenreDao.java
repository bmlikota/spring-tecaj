package net.springinaction.exercise1;

import net.springinaction.exercise1.dao.GenreDao;
import net.springinaction.exercise1.model.Genre;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestGenreDao {

	public static Logger log = LoggerFactory.getLogger(TestGenreDao.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-workshop-02/exercise-1/ticket-ctx.xml");
		
		//TEST Genre DAO
		GenreDao genreDao = (GenreDao) ctx.getBean("genreDao");

		// fetch max id from db...
		int newId = genreDao.findMaxId();
		newId++;
		Genre g = new Genre();
		g.setId(new Long(newId));
		g.setName("Conference");
		g = genreDao.create(g);
		log.info("INSERTED genre: "  + g);

		
		g.setName("Spring conference");
		int r = genreDao.update(g);
		log.info(r + " rows updated");

		g = genreDao.findById(new Long(newId));
		log.info("UPDATED genre: " + g);
		
		//TEST Shows DAO....
		
	}

}
