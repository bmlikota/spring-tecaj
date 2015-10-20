package net.springinaction.exercise1.dao.repository;

import java.util.List;

import net.springinaction.exercise1.model.Genre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
	
	Genre findByName(String name);
	
	// … where genre.name like ?1
	List<Genre> findByNameStartingWithIgnoreCase(String name);
	
	List<Genre> findAll();
}
