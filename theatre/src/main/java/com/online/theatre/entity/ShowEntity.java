package com.online.theatre.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shows")
public class ShowEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="showid")
	private Integer showId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="theatreid")
	private TheatreEntity theatreEntity;
	

	
	
	@Column(name="showdate")
	private Date showDate;
	
	@Column(name="showtime")
	private Time showTime;
	
	@Column(name="seatavailable")
	private Integer seatAvailable;

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Time getShowTime() {
		return showTime;
	}

	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}

	public Integer getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(Integer seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	public TheatreEntity getTheatreEntity() {
		return theatreEntity;
	}

	public void setTheatreEntity(TheatreEntity theatreEntity) {
		this.theatreEntity = theatreEntity;
	}




}
