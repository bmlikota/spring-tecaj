package net.springinaction.exercise1.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "SHOW")
public class Show {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME", length = 80, nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "GENRE_ID", nullable = false)
	private Genre genre;
	
	@ManyToOne
	@JoinColumn(name = "SEATING_PLAN_ID", nullable = false)
	private SeatingPlan seatingPlan;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="SHOW_PERFORMER", 
                joinColumns={@JoinColumn(name="SHOW_ID")}, 
                inverseJoinColumns={@JoinColumn(name="PERFORMER_ID")})
	private Set<Performer> performers;
	
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	//--- set / get methods ---------------------------------------------------
	
	public SeatingPlan getSeatingPlan() {
		return seatingPlan;
	}
	public void setSeatingPlan(SeatingPlan seatingPlan) {
		this.seatingPlan = seatingPlan;
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
	
	
	public Set<Performer> getPerformers() {
		return performers;
	}
	public void setPerformers(Set<Performer> performers) {
		this.performers = performers;
	}
}
