package com.online.theatre.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="theatre")
public class TheatreEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="theatreid")
	private Integer theatreId;
	
	@Column(name="theatrename")
	private String theatreName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="price")
	private Integer price;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="movieid")
	private MovieEntity movieEntity;
	
	@Column(name="seatcapacity")
	private Integer seatCapacity;
		
	
	
	public Integer getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(Integer seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public MovieEntity getMovieEntity() {
		return movieEntity;
	}

	public void setMovieEntity(MovieEntity movieEntity) {
		this.movieEntity = movieEntity;
	}

}
