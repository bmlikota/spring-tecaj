package com.springinaction.web.form;

import java.io.Serializable;

import net.springinaction.exercise1.model.Show;

public class ShowForm  implements Serializable {

	private Long id;

	private String name;

	private Long genreId;

	private Long seatingPlanId;

	public ShowForm(Show show) {
		this.id = show.getId();
		this.name = show.getName();
		if (show.getGenre() != null) {
			this.genreId = show.getGenre().getId();
		}
		if (show.getSeatingPlan() != null) {
			this.seatingPlanId = show.getSeatingPlan().getId();
		}
	}

	public ShowForm() {
		// default contructor....
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public Long getSeatingPlanId() {
		return seatingPlanId;
	}

	public void setSeatingPlanId(Long seatingPlanId) {
		this.seatingPlanId = seatingPlanId;
	}

}
