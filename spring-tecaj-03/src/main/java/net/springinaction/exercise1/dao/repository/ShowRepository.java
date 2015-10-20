package net.springinaction.exercise1.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.springinaction.exercise1.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{

	List<Show> findByGenreId(Long id);
	
	@Query("SELECT DISTINCT s FROM Show s join s.performers p WHERE p.name LIKE %:name% ORDER by s.name ASC")
	List<Show> findByPerformerName(@Param("name") String performerName);

}
