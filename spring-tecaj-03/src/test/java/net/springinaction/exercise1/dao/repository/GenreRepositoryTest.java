package net.springinaction.exercise1.dao.repository;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import net.springinaction.exercise1.model.Genre;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-workshop-03/exercise-1/test-ticket-ctx.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup(value = {
        "/spring-workshop-03/dbunit/shows-data.xml"
})
@Transactional
public class GenreRepositoryTest {
	public static final Long EXISTING_ID = 1000001L; 
	public static final Long NON_EXISTING_ID = -1L;
	
	@Autowired 
	GenreRepository genreRepository;
	
	@Test
	public void testFindById_whenRecordExists() {
		// arrange ...
		
		// act ...
		Genre genre = genreRepository.findOne(EXISTING_ID);
		
		// assert ...
		assertThat(genre).isNotNull();
		assertThat(genre.getId()).isEqualTo(EXISTING_ID);
		assertThat(genre.getName()).isEqualTo("Drama");
	}
	
	@Test
	public void testFindById_whenRecordNotFound() {
		// arrange ...
		
		// act ...
		Genre genre = genreRepository.findOne(NON_EXISTING_ID);
				
		// assert ...
		assertThat(genre).isNull();
	}
	
	@Test
	public void testFindAll() {
		// arrange ...
		
		// act ...
		List<Genre> result = genreRepository.findAll();
		
		// assert ...
		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(8);
	}
	
	@Test
	public void testFindByName_recordMatch() {
		// arrange ...
		
		// act ...
		Genre genre = genreRepository.findByName("Commedy");
		
		// assert ...
		assertThat(genre).isNotNull();
		assertThat(genre.getName()).isEqualTo("Commedy");
	}
	
	@Test
	public void testFindByNameStartsWith_matchingRecordsFound() {
		// arrange ...
		
		// act ...
		List<Genre> result = genreRepository.findByNameStartingWithIgnoreCase("c");
		
		// assert ...
		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(2);
	}
	
	@Test
	public void testSave_newEntity() {
		// arrange ...
		Genre genre = new Genre();
		genre.setName("Some name");
		
		// act ...
		Genre savedGenre = genreRepository.save(genre);
				
		// assert ...
		assertThat(savedGenre).isNotNull();
		assertThat(savedGenre.getId()).isNotNull();
		assertThat(savedGenre.getName()).isEqualTo("Some name");
	}
	
	@Test
	public void testSave_existingEntity() {
		// arrange ...
		Genre genre = genreRepository.findOne(EXISTING_ID);
		genre.setName("ZZZZ");
		
		// act ...
		Genre savedGenre = genreRepository.save(genre);
		Genre dbGenre = genreRepository.findOne(EXISTING_ID);
				
		// assert ...
		assertThat(savedGenre).isNotNull();
		assertThat(savedGenre.getId()).isNotNull();
		assertThat(savedGenre.getName()).isEqualTo("ZZZZ");
		
		assertThat(dbGenre).isNotNull();
		assertThat(dbGenre.getId()).isEqualTo(EXISTING_ID);
		assertThat(genre.getName()).isEqualTo(genre.getName());
	}
	
	
}
