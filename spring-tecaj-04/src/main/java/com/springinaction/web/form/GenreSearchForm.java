package com.springinaction.web.form;

import java.io.Serializable;

import org.springframework.util.StringUtils;

/**
 * 
 * @author domagoj
 *
 */
public class GenreSearchForm implements Serializable {

	private String searchName;
	
	public GenreSearchForm() {
		// empty
	}

	public boolean isEmpty() {
		if (StringUtils.hasText(searchName)) {
			return false;
		}
		return true;
	}
	
	//--- set / get methods ---------------------------------------------------
	
	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
}
