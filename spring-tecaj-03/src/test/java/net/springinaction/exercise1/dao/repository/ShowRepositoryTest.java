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

import net.springinaction.exercise1.model.Show;

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
public class ShowRepositoryTest {
	public static final Long EXISTING_ID = 9L; 
	public static final Long NON_EXISTING_ID = -1L;
	
	@Autowired 
	ShowRepository showRepository;
	
	@Test
	public void testFindById_whenRecordExists() {
		// arrange ...
		
		// act ...
		Show show = showRepository.findOne(EXISTING_ID);
		
		// assert ...
		assertThat(show).isNotNull();
		assertThat(show.getId()).isEqualTo(EXISTING_ID);
		assertThat(show.getName()).isEqualTo("X-Men");
		assertThat(show.getPerformers()).isNotNull();
		assertThat(show.getPerformers().size()).isEqualTo(2);
	}
	
	@Test
	public void testFindById_whenRecordNotFound() {
		// arrange ...
		
		// act ...
		Show show = showRepository.findOne(NON_EXISTING_ID);
				
		// assert ...
		assertThat(show).isNull();
	}
	
	//---
	
	@Test
	public void testFindByGenreId_whenMultipleRecordsAreFound() {
		// arrange ...
		
		// act ...
		List<Show> shows = showRepository.findByGenreId(1000006L);
				
		// assert ...
		assertThat(shows).isNotNull();
		assertThat(shows.size()).isGreaterThan(1);
	}
	
	@Test
	public void testFindByPerformerName_whenMultipleRecordsAreFound() {
		// arrange ...
		
		// act ...
		List<Show> shows = showRepository.findByPerformerName("McKellen");
				
		// assert ...
		assertThat(shows).isNotNull();
		assertThat(shows.size()).isEqualTo(2);
	}
	
	
}
