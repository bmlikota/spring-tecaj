package net.springinaction.exercise1.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "PERFORMER")
public class Performer {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "P_TYPE")
	private PerformerType type;
	
//	@ManyToMany(mappedBy="performers")
//	private Set<Show> shows;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	//--- set / get methods ---------------------------------------------------
	
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

	public String getType() {
		return type.getName();
	}

	public void setType(String type) {
		this.type = PerformerType.getEnumByName(type);
	}

//	public Set<Show> getShows() {
//		return shows;
//	}
//
//	public void setShows(Set<Show> shows) {
//		this.shows = shows;
//	}
	
}
