package com.springinaction.web.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springinaction.web.form.GenreForm;

import net.springinaction.exercise1.model.Genre;
import net.springinaction.exercise1.service.GenreService;

/**
 * GenreForm Validator.
 * 
 * @author domagoj
 *
 */
@Component
public class GenreFormValidator implements Validator {
	public static Logger log = LoggerFactory.getLogger(GenreFormValidator.class);
	
	@Autowired
	private GenreService genreService;
	
	@Override
    public boolean supports(Class<?> clazz) {
        return GenreForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	GenreForm form = (GenreForm) target;
    	
    	// 1. first check if name is not empty
    	if(!StringUtils.hasText(form.getName())) {
    		errors.rejectValue ("name", "genre.name.empty", "Genre name may not be empty!");
    		log.debug("Submitted Genre name is empty ---> REJECTING");
    	} else {
    		//2. check for uniqueness of the genre name ...
    		form.setName(form.getName().trim());
    		Genre genreFromDb = genreService.findByName(form.getName());
    		
    		if (genreFromDb == null) {
    			return;
    		}
    		
    		if (genreFromDb.getId().equals(form.getGenreId())) {
    			return;
    		}
    		log.info("Genre with submitted name='{}' already exists=[{}] ---> REJECTING", form.getName(), genreFromDb);
    		errors.rejectValue ("name", "genre.name.notunique", "Genre record with that name already exists!");
    	}
    	

    }

}
