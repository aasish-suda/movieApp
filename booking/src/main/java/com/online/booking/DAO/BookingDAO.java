package com.online.booking.DAO;

import java.util.List;

import com.online.booking.Model.Booking;

public interface BookingDAO {
	
	public List<Booking> getAllBooking(String userName);
	public String addNewBooking(Booking booking);
	public String cancelBooking(Integer bookingId);
	public List<Booking> getAllBooking();
	

}
