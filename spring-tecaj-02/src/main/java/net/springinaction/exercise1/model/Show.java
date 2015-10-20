package net.springinaction.exercise1.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Show {

	private long id;
	private String name;
	private Genre genre;
	private int seatingPlanId;
	
	public int getSeatingPlanId() {
		return seatingPlanId;
	}
	public void setSeatingPlanId(int seatingPlanId) {
		this.seatingPlanId = seatingPlanId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
