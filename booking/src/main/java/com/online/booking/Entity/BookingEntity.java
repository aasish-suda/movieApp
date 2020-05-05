package com.online.booking.Entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class BookingEntity {
	@Id
	@Column(name="bookingid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private UserEntity userEntity;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="showid")
	private ShowEntity showEntity;
	
	@Column(name="moviename")
	private String movieName;
	
	@Column(name="theatrename")
	private String theatreName;
	
	@Column(name="showdate")
	private Date showDate;
	
	@Column(name="showtime")
	private Time showTime;
	
	@Column(name="seatsbooked")
	private Integer seatsBooked;
	
	@Column(name="totalamount")
	private Integer totalAmount;
	
	@Column(name="bookingstatus")
	private String bookingStatus;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public ShowEntity getShowEntity() {
		return showEntity;
	}

	public void setShowEntity(ShowEntity showEntity) {
		this.showEntity = showEntity;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
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

	public Integer getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	
	

}
