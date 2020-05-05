package com.online.booking.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.booking.Entity.BookingEntity;
import com.online.booking.Entity.ShowEntity;
import com.online.booking.Entity.UserEntity;
import com.online.booking.Model.Booking;
import com.online.booking.Repository.BookingRepository;

@Repository(value="bookingDAO")
public class BookingDAOImpl implements BookingDAO {
	@Autowired
	private BookingRepository bookingRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Booking> getAllBooking(String userName) {
		Query query= entityManager.createQuery("Select m from BookingEntity m");
		@SuppressWarnings("unchecked")
		List<BookingEntity> bookingEntityList=query.getResultList();
		List<Booking> bookingList= new ArrayList<Booking>();
		System.out.println(bookingEntityList);
		if(bookingEntityList.isEmpty()) {
			return null;
		}
		else {
			for(BookingEntity bookingEntity:bookingEntityList) {
				
				if(bookingEntity.getUserEntity().getUserName().equals(userName) && bookingEntity.getBookingStatus().equals("A")) {
					Booking booking= new Booking();
					booking.setBookingId(bookingEntity.getBookingId());
					booking.setBookingStatus("Active");
					booking.setSeatsBooked(bookingEntity.getSeatsBooked());
					booking.setShowId(bookingEntity.getShowEntity().getShowId());
					booking.setShowDate(bookingEntity.getShowEntity().getShowDate());
					booking.setShowTime(bookingEntity.getShowEntity().getShowTime());
					booking.setMovieName(bookingEntity.getShowEntity().getTheatreEntity().getMovieEntity().getMovieName());
					booking.setTheatreName(bookingEntity.getShowEntity().getTheatreEntity().getTheatreName());
//					Integer totalAmount= bookingEntity.getShowEntity().getTheatreEntity().getPrice()*(booking.getSeatsBooked());
//					System.out.println(totalAmount);
					booking.setTotalAmount(bookingEntity.getTotalAmount());
					booking.setUserName(bookingEntity.getUserEntity().getUserName());
					bookingList.add(booking);
				}
			}
			return bookingList;
		}
	}

	@Override
	public String cancelBooking(Integer bookingId) {
		BookingEntity bookingEntity= entityManager.find(BookingEntity.class, bookingId);
		entityManager.detach(bookingEntity);
		if(bookingEntity!=null && bookingEntity.getBookingStatus().equals("A") ) {
			bookingEntity.setBookingStatus("C");
			ShowEntity showEntity=bookingEntity.getShowEntity();
			bookingEntity.getShowEntity().setSeatAvailable(showEntity.getSeatAvailable()+bookingEntity.getSeatsBooked());
			bookingRepository.save(bookingEntity);
//			entityManager.persist(bookingEntity);
			System.out.println(bookingEntity.getBookingStatus());
			return "C";
		}
		else return null;
	}

	@Override
	public List<Booking> getAllBooking() {
		Query query= entityManager.createQuery("Select m from BookingEntity m");
		@SuppressWarnings("unchecked")
		List<BookingEntity> bookingEntityList=query.getResultList();
		List<Booking> bookingList= new ArrayList<Booking>();
		System.out.println(bookingEntityList);
		if(bookingEntityList.isEmpty()) {
			return null;
		}
		else{
				for(BookingEntity bookingEntity:bookingEntityList) {
					Booking booking= new Booking();
					booking.setBookingId(bookingEntity.getBookingId());
					if(bookingEntity.getBookingStatus().equals("A")) {
						booking.setBookingStatus("Active");
					}
					else {
						booking.setBookingStatus("Canceled");
					}
					booking.setSeatsBooked(bookingEntity.getSeatsBooked());
					booking.setShowId(bookingEntity.getShowEntity().getShowId());
					booking.setShowDate(bookingEntity.getShowEntity().getShowDate());
					booking.setShowTime(bookingEntity.getShowEntity().getShowTime());
					booking.setMovieName(bookingEntity.getShowEntity().getTheatreEntity().getMovieEntity().getMovieName());
					booking.setTheatreName(bookingEntity.getShowEntity().getTheatreEntity().getTheatreName());
					booking.setTotalAmount(bookingEntity.getTotalAmount());
					booking.setUserName(bookingEntity.getUserEntity().getUserName());
					bookingList.add(booking);
				}
			}
			return bookingList;
		}

	@Override
	public String addNewBooking(Booking booking) {
		
		BookingEntity bookingEntity= new BookingEntity();
		ShowEntity showEntity=entityManager.find(ShowEntity.class, booking.getShowId());
//		entityManager.detach(showEntity);
		if(booking.getSeatsBooked()<showEntity.getSeatAvailable()) {
		showEntity.setSeatAvailable(showEntity.getSeatAvailable()-booking.getSeatsBooked());
//		TheatreEntity theatreEntity= entityManager.find(TheatreEntity.class, showEntity.getTheatreEntity().getTheatreId());
		UserEntity userEntity=entityManager.find(UserEntity.class, booking.getUserName());
		bookingEntity.setBookingStatus("A");
		bookingEntity.setMovieName(showEntity.getTheatreEntity().getMovieEntity().getMovieName());
		bookingEntity.setTheatreName(showEntity.getTheatreEntity().getTheatreName());
		bookingEntity.setSeatsBooked(booking.getSeatsBooked());
		bookingEntity.setShowDate(showEntity.getShowDate());
		bookingEntity.setShowTime(showEntity.getShowTime());
		bookingEntity.setShowEntity(showEntity);
		bookingEntity.setUserEntity(userEntity);
		bookingEntity.setTotalAmount(booking.getSeatsBooked()*showEntity.getTheatreEntity().getPrice());
//		showRepository.save(showEntity);
//		entityManager.persist(showEntity);
		bookingEntity.setShowEntity(showEntity);
		bookingRepository.save(bookingEntity);
		return "booking Added Successfully";
	}
		else return "booking can't be made";
}
}
