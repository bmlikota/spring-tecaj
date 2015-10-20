package net.springinaction.exercise1.dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import net.springinaction.exercise1.model.Genre;

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
@ContextConfiguration(locations={"/spring-workshop-02/test-context.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("/spring-workshop-02/dbunit/show-data.xml")
public class GenreDaoTest {
	
	@Autowired
	private GenreDao genreDao;
	
	@Test
	public void testListAll() {
		List<Genre> result = genreDao.findAll();
		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(4);
		
	}
	
	@Test
	public void testFindById() {
		//arrange
		//act
		Genre genre = genreDao.findById(1l);
		
		
		//assert
		assertThat(genre).isNotNull();
		assertThat(genre.getName()).isEqualTo("Commedy");
	}
	
	@Test
	public void testFindById_notFound() {
		//arrange
		//act
		Genre genre = genreDao.findById(5l);
		
		//assert
		assertThat(genre).isNull();
	}
	
	@Test
	public void testCreateGenre() {
		//arrange
		Genre genre = new Genre();
		genre.setName("History");
		long id = genreDao.findMaxId();
		genre.setId(id+1);
		
		//act
		Genre target = genreDao.create(genre);
				
		//assert
		assertThat(target).isNotNull();
		assertThat(target.getName()).isEqualTo("History");
	}
	
	@Test
	public void testUpdateGenre() {
		//arrange
		Genre genre = genreDao.findById(4l);
		genre.setName("Political");
		
		//act
		int target = genreDao.update(genre);
		
		//assert
		assertThat(target).isEqualTo(1);
		
		genre = genreDao.findById(4l);
		assertThat(genre).isNotNull();
		assertThat(genre.getName()).isEqualTo("Political");
		
	}
	
	public GenreDao getGenreDao() {
		return genreDao;
	}

	public void setGenreDao(GenreDao genreDao) {
		this.genreDao = genreDao;
	}

}
