package com.online.theatre.model;

import java.sql.Date;
import java.sql.Time;

public class Show {
	private Integer showId;
	private Theatre theatre;
	private Date showDate;
	private Time showTime;
	private Integer seatCapcity;
	private String errorMesssage;
	
	public String getErrorMesssage() {
		return errorMesssage;
	}
	public void setErrorMesssage(String errorMesssage) {
		this.errorMesssage = errorMesssage;
	}
	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
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
	public Integer getSeatCapcity() {
		return seatCapcity;
	}
	public void setSeatCapcity(Integer seatCapcity) {
		this.seatCapcity = seatCapcity;
	}
	
	
	
	

}
