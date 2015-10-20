package net.springinaction.exercise1.service;

import java.util.List;

import net.springinaction.exercise1.model.Show;

public interface ShowService {

	Show findById(long id);

	Show save(Show show);

	List<Show> findAll();
	
	void delete(long id);
	
	void deleteAll(); 

	Show findByName (String name);
	
	List<Show> findByGenreId(Long genreId);
	
	long count();
	
	List<Show> searchByNameAndPerformer(String showName, String performerName);
	
}