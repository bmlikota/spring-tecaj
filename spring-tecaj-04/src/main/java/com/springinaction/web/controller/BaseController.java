package com.springinaction.web.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Base class of the app Controller hierarchy.
 * 
 * @author domagoj
 *
 */
public abstract class BaseController {

	/**
	 * Supplies full name of logged in user to model.
	 * 
	 * @return
	 */
	@ModelAttribute("userFullName")
	public String getUserFullName(){
	    return "Janko Strižić";
	}
}
