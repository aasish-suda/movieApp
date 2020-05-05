package com.online.booking.Contoller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.booking.Model.Booking;
import com.online.booking.Service.BookingService;

@CrossOrigin
@RestController
@RequestMapping("/booking")
@ComponentScan("com.online.booking.*")
public class BookingController {
	@Autowired
	private BookingService	bookingService;
	
	@PostMapping("/getBooking")
	public ResponseEntity<List<Booking>> getBookingForUser(@PathParam(value="userName")String userName){
		try {
			List<Booking> bookingList	= bookingService.getBookingForUser(userName);
			return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			List<Booking> errorList= new ArrayList<Booking>();
			Booking booking= new Booking();
			booking.setErrorMessage(e.getLocalizedMessage());
			errorList.add(booking);
			return new ResponseEntity<List<Booking>>(errorList,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/cancelBooking")
	public ResponseEntity<String> cancelBooking(@PathParam(value="bookingId") Integer bookingId){
		try {
			String message=bookingService.cancelBooking(bookingId);
			return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			String errorMessage=e.getLocalizedMessage();
			return new ResponseEntity<String>(errorMessage,HttpStatus.BAD_GATEWAY);
		}
		
	}
	@PostMapping("/addBooking")
	public ResponseEntity<String> bookTheShow(@RequestBody Booking booking){
		try {
			String message=bookingService.bookTheShow(booking);
			return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			String errorMessage=e.getLocalizedMessage();
			return new ResponseEntity<String>(errorMessage,HttpStatus.BAD_GATEWAY);
		}
		
	}
	
	@GetMapping("/viewAllBooking")
	public ResponseEntity<List<Booking>> viewAllBooking(){
		try {
			List<Booking> bookingList	= bookingService.getAllBooking();
			return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			List<Booking> errorList= new ArrayList<Booking>();
			Booking booking= new Booking();
			booking.setErrorMessage(e.getLocalizedMessage());
			errorList.add(booking);
			return new ResponseEntity<List<Booking>>(errorList,HttpStatus.NOT_FOUND);
		}
	}

}
