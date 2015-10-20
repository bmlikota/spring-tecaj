package net.springinaction.exercise1.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Genre {

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
