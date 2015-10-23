package com.springinaction.web.form;

import org.springframework.util.StringUtils;

public class ShowSearchForm {

	private String searchName;
	
	public ShowSearchForm() {
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
