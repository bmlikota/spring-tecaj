package com.springinaction.web.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	//--- flash messages util methods ------
	
	public Map<String, String> addMessage(String severity, String message) {
		Map<String, String> messages = new HashMap<String, String>();
		messages.put(severity, message);
		return messages;
	}
	
}
