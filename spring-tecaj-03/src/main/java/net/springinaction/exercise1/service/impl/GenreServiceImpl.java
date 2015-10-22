package net.springinaction.exercise1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springinaction.exercise1.dao.repository.GenreRepository;
import net.springinaction.exercise1.model.Genre;
import net.springinaction.exercise1.service.GenreService;

/**
 * 
 * @author domagoj
 *
 */
@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository repository;
	
	public Genre findById(Long id) {
		return repository.findOne(id);
	}
	
	public Genre findByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Genre> searchByName(String name) {
		return repository.findByNameStartingWithIgnoreCase(name);
	}

	public Genre save(Genre genre) {
		return repository.save(genre);
	}
	
	public List<Genre> findAll() {
		return repository.findAll();
	}
	
	public long count() {
		return repository.count();
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
	
}
