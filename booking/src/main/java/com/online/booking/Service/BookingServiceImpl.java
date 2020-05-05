package com.online.booking.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.booking.DAO.BookingDAO;
import com.online.booking.Model.Booking;

@Service(value="bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingDAO bookingDAO;

	@Override
	public List<Booking> getBookingForUser(String userName) throws Exception {
		List<Booking> bookingList=bookingDAO.getAllBooking(userName);
		if(bookingList.isEmpty()) {
			throw new Exception("no theatre with this movie");
		}
		else {
			return bookingList;
		}
	}

	@Override
	public List<Booking> getAllBooking() throws Exception {
		List<Booking> bookingList=bookingDAO.getAllBooking();
		if(bookingList.isEmpty()) {
			throw new Exception("no bookings are there");
		}
		else {
			return bookingList;
		}
	}

	@Override
	public String bookTheShow(Booking booking) throws Exception {
		String message= bookingDAO.addNewBooking(booking);
		if(message!=null) {
			return message;
		}
		else throw new Exception("no booking found with the BOOKING ID");
	}

	@Override
	public String cancelBooking(Integer bookingId) throws Exception {
		String message= bookingDAO.cancelBooking(bookingId);
		if(message.equals("C")) {
			String outputMessage="Booking Sucessfully canceled";
			return outputMessage;
		}
		else throw new Exception("no booking found with the BOOKING ID");
	}

}
