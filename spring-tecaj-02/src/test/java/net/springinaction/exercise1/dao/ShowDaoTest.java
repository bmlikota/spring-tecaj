package net.springinaction.exercise1.dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import net.springinaction.exercise1.model.Genre;
import net.springinaction.exercise1.model.Show;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-workshop-02/test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("/spring-workshop-02/dbunit/show-data.xml") // puni bazu
public class ShowDaoTest {

	@Autowired
	protected ShowDao showDao;

	@Autowired
	protected GenreDao genreDao;

	@Test
	public void testListAll() {

		List<Show> shows = showDao.findAll();
		assertThat(shows).isNotNull();
		assertThat(shows.size()).isEqualTo(3);

	}

	@Test
	public void testFindById_whenRecordIsFound() {
		// arrange
		// act

		Show show = showDao.findById(1l);

		// assert
		assertThat(show).isNotNull();
		assertThat(show.getName()).isEqualTo("Prohujalo s vihorom");
		assertThat(show.getSeatingPlanId()).isEqualTo(1);
		assertThat(show.getId()).isNotNull();
		assertThat(show.getGenre()).isNotNull();
		assertThat(show.getGenre().getName()).isEqualTo("Commedy");
	}

	@Test
	public void testFindById_notFound() {
		// arrange
		// act

		Show show = showDao.findById(4l);

		// assert
		assertThat(show).isNull();
	}

	@Test
	public void testFindByName() {
		// arrange
		// act

		Show show = showDao.findByName("Prohujalo s vihorom");

		// assert
		assertThat(show).isNotNull();
		assertThat(show.getName()).isEqualTo("Prohujalo s vihorom");
	}

	@Test
	public void testCreate() { // TODO
		// arrange
		Genre genre = genreDao.findById(1l);
		int seatingPlanId = 1;
		String name = "Vlak u snijegu";

		Show show = new Show();
		show.setGenre(genre);
		show.setName(name);
		show.setSeatingPlanId(seatingPlanId);

		// act
		int target = showDao.create(show);

		Show showSaved= showDao.findByName(name);

		// assert
		assertThat(target).isEqualTo(1);
		assertThat(showSaved).isNotNull();
		assertThat(showSaved.getGenre().getId()).isEqualTo(genre.getId());
		assertThat(showSaved.getGenre().getName()).isEqualTo(genre.getName());
		assertThat(showSaved.getSeatingPlanId()).isEqualTo(1);
		assertThat(showSaved.getName()).isEqualTo(name);
		
	}

	@Test
	public void testUpdate() {
		// arrange
		String newName = "Dummy Show " + System.currentTimeMillis();
		Show show = showDao.findById(1l);
		show.setName(newName);
		show.setSeatingPlanId(3);

		// act
		int target = showDao.update(show);
		Show targetShow = showDao.findById(1l);

		// assert
		assertThat(target).isEqualTo(1);
		assertThat(targetShow.getSeatingPlanId()).isEqualTo(3);
		assertThat(targetShow.getName()).isEqualTo(newName);
	}

	@Test
	public void testDelete() {
		// arrange
		Show show = showDao.findById(1l);

		// act
		showDao.delete(show.getId());
		// showDao.deleteAll();
		Show target = showDao.findById(1l);

		// assert
		// assertThat(target).isNull();
		assertThat(target).isNull();
	}

	// --- set / get methods ---------------------------------------------------

	public ShowDao getShowDao() {
		return showDao;
	}

	public void setShowDao(ShowDao showDao) {
		this.showDao = showDao;
	}

}
