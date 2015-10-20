package net.springinaction.exercise1.dao;

import java.util.List;

import net.springinaction.exercise1.model.Genre;

public interface GenreDao {

	public abstract Genre findById(Long id);
	
	public List<Genre> findAll();
	
	public int findMaxId();

	public abstract int update(Genre genre);

	public abstract Genre create(Genre genre);

}