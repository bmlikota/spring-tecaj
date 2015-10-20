package net.springinaction.exercise1.dao;

import java.util.List;

import net.springinaction.exercise1.model.Show;

public interface ShowDao {

	public Show findById(long id);

	public int create(Show show);

	public int update(Show show);

	public List<Show> findAll();
	
	public List<Show> findByGenreId(Long genreId);
	
	public void delete(long id);
	
	public void deleteAll(); 

	public Show findByName (String name);
}