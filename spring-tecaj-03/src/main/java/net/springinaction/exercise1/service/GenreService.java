package net.springinaction.exercise1.service;

import java.util.List;

import net.springinaction.exercise1.model.Genre;

public interface GenreService {

	Genre findById(Long id);
	
	Genre findByName(String name);
	
	List<Genre> searchByName(String name);
	
	List<Genre> findAll();
	
	Genre save(Genre genre);
	
	long count();
	
	void delete(Long id);

}