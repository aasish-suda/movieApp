package com.online.booking.Service;

import java.util.List;

import com.online.booking.Model.Booking;

public interface BookingService {
	public List<Booking> getBookingForUser(String userName) throws Exception;
	public List<Booking> getAllBooking() throws Exception;
	public String bookTheShow(Booking booking) throws Exception;
	public String cancelBooking(Integer bookingId) throws Exception;

}
