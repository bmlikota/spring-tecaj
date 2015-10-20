package com.springinaction.web.form;

import java.io.Serializable;

import net.springinaction.exercise1.model.Genre;

public class GenreForm implements Serializable {

	private Long genreId;
	
	private String name;
	
	public GenreForm() {
		// default contructor....
	}
	
	public GenreForm(Genre genre) {
		this.genreId = genre.getId();
		this.name = genre.getName();
	}

	//--- set / get methods ---------------------------------------------------
		
	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
