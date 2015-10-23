package com.springinaction.web.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springinaction.web.form.ShowForm;

import net.springinaction.exercise1.model.Show;
import net.springinaction.exercise1.service.ShowService;

/**
 * GenreForm Validator.
 * 
 * @author domagoj
 *
 */
@Component
public class ShowFormValidator implements Validator {
	public static Logger log = LoggerFactory.getLogger(GenreFormValidator.class);
	
	@Autowired
	private ShowService showService;
	
	@Override
    public boolean supports(Class<?> clazz) {
        return ShowForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	ShowForm form = (ShowForm) target;
    	
    	// 1. first check if name is not empty
    	if(!StringUtils.hasText(form.getName())) {
    		errors.rejectValue ("name", "genre.name.empty", "Genre name may not be empty!");
    	} else {
    		//2. check for uniqueness of the genre name ...
    		form.setName(form.getName().trim());
    		Show showFromDb = showService.findByName(form.getName());
    		
    		if (showFromDb == null) {
    			return;
    		}

    		if (showFromDb.getId().equals(form.getId())) {
    			return;
    		}
    		log.info("Genre with submitted name='{}' already exists=[{}] ---> REJECTING", form.getName(), showFromDb);
    		errors.rejectValue ("name", "genre.name.notunique", "Genre record with that name already exists!");
    	}
    	

    }

}
