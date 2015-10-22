package net.springinaction.exercise1.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.springinaction.exercise1.dao.repository.ShowRepository;
import net.springinaction.exercise1.model.Show;
import net.springinaction.exercise1.service.ShowService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
/**
 * 
 * @author domagoj
 *
 */
@Service
public class ShowServiceImpl implements ShowService {
	public static Logger log = LoggerFactory.getLogger(ShowServiceImpl.class);
			
	@Autowired
	ShowRepository repository;
	
	public Show findById(long id) {
		return repository.findOne(id);
	}
	
	public Show save(Show show) {
		return repository.save(show);
	}
		
	public List<Show> findAll() {
		return repository.findAll();
	}
	
	public Show findByName (String name) {
		//TODO: implement me
		return null;
	}
	

	public void deleteAll() {
		//TODO: implement me
	}
	
	public void delete(long id) {
		//TODO: implement me
	}
	
	public List<Show> findByGenreId(Long genreId) {
		return repository.findByGenreId(genreId);
	}
	
	public long count() {
		return repository.count();
	}

	@Override
	public List<Show> searchByNameAndPerformer(String showName, String performerName) {
		List<Show> result = new ArrayList<Show>();
		if (StringUtils.hasText(showName) && !StringUtils.hasText(performerName)) {
			//TODO: implementirati pomoću jpql koji traži ignore case i da ime sadrži ovu riječ, sortira rezultate po imenu show-a ASC
			//result = repository.findByName(name);
		} else if (!StringUtils.hasText(showName) && StringUtils.hasText(performerName)) {
			result = repository.findByPerformerName(showName);
		} else if (StringUtils.hasText(showName) && StringUtils.hasText(performerName)) {
			//TODO: implementirati pomoću jpql koji traži ignore case i da ime show-a sadrži ovu riječ isto i za performerName, sortira rezultate po imenu show-a ASC
			//result = repository.findByNameAndPerformerName(name);
		}
		return result;
	}
	
	
	
}
