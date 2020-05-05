package com.online.theatre.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.theatre.entity.MovieEntity;
import com.online.theatre.entity.ShowEntity;
import com.online.theatre.entity.TheatreEntity;
import com.online.theatre.model.Movie;
import com.online.theatre.model.Show;
import com.online.theatre.model.Theatre;
import com.online.theatre.repository.ShowRepository;
import com.online.theatre.repository.TheatreRepository;

@Repository(value="theatreDAO")
public class TheatreDAOImpl implements TheatreDAO {
	@Autowired
	private TheatreRepository theatreRepository;
	private ShowRepository showRepository;
	
	@PersistenceContext
	private EntityManager entitymanger;

	@Override
	public List<Theatre> getTheatresByMovie(Integer movieId){
		Iterable<TheatreEntity> theratreEntityList= theatreRepository.findAll();
		List<Theatre> theatreList= new ArrayList<Theatre>();
		for (TheatreEntity theatreEntity : theratreEntityList) {
			if (theatreEntity.getMovieEntity().getMovieId().equals(movieId)) {
				Theatre theatre= new Theatre();
				theatre.setTheatreId(theatreEntity.getTheatreId());
				theatre.setTheatreName(theatreEntity.getTheatreName());
				theatre.setLocation(theatreEntity.getLocation());
//				theatre.setDate(theatreEntity.getShowDate());
//				theatre.setSeatAvailable(theatreEntity.getSeatAvailable());
				theatre.setPrice(theatreEntity.getPrice());
				Movie movie = new Movie();
				movie.setMovieId(theatreEntity.getMovieEntity().getMovieId());
				movie.setMovieName(theatreEntity.getMovieEntity().getMovieName());
				movie.setGenre(theatreEntity.getMovieEntity().getGenre());
				movie.setRating(theatreEntity.getMovieEntity().getRating());
				theatre.setMovie(movie);
				theatreList.add(theatre);
			}
		}
		return theatreList;
	}

	@Override
	public List<Show> getShowByTheatre(Integer theatreId) {
		System.out.println("Hai from DAO impl");
		ShowEntity show1=entitymanger.find(ShowEntity.class, 1);
//		System.out.println(show1.getSeatCapacity());
		Iterable<ShowEntity> showEntityList= showRepository.findAll();
		List<Show> showList= new ArrayList<Show>();
		System.out.println("Hai after getting show entity");
		for (ShowEntity showEntity : showEntityList) {
			System.out.println(showEntity.getShowDate());
			if (showEntity.getTheatreEntity().getTheatreId().equals(theatreId)) {
				Show show=new Show();
				Theatre theatre= new Theatre();
				Movie movie = new Movie();
				show.setSeatCapcity(showEntity.getSeatCapacity());
				show.setShowDate(showEntity.getShowDate());
				show.setShowTime(showEntity.getShowTime());
				show.setShowId(showEntity.getShowId());
				System.out.println(showEntity.getShowId());
				theatre.setTheatreId(showEntity.getTheatreEntity().getTheatreId());
				theatre.setTheatreName(showEntity.getTheatreEntity().getTheatreName());
				theatre.setPrice(showEntity.getTheatreEntity().getPrice());
				theatre.setLocation(showEntity.getTheatreEntity().getLocation());
				movie.setMovieId(showEntity.getTheatreEntity().getMovieEntity().getMovieId());
				movie.setMovieName(showEntity.getTheatreEntity().getMovieEntity().getMovieName());
				movie.setRating(showEntity.getTheatreEntity().getMovieEntity().getRating());
				movie.setGenre(showEntity.getTheatreEntity().getMovieEntity().getGenre());
				theatre.setMovie(movie);		
				show.setTheatre(theatre);
				showList.add(show);
			}
		}
		return showList;
	}

	@Override
	public String addNewTheatre(Theatre theatre) {
		TheatreEntity theatreEntity = new TheatreEntity();
		theatreEntity.setTheatreName(theatre.getTheatreName());
		theatreEntity.setLocation(theatre.getLocation());
//		theatreEntity.setSeatAvailable(theatre.getSeatAvailable());
//		theatreEntity.setShowDate(theatre.getDate());
		theatreEntity.setPrice(theatre.getPrice());
//		MovieEntity movieEntity= new MovieEntity();
//		movieEntity.setMovieId(theatre.getMovie().getMovieId());
//		movieEntity.setMovieName(theatre.getMovie().getMovieName());
//		movieEntity.setGenre(theatre.getMovie().getGenre());
//		movieEntity.setRating(theatre.getMovie().getRating());
		MovieEntity movieEntity =entitymanger.find(MovieEntity.class, theatre.getMovie().getMovieId());
		System.out.println(movieEntity.getMovieName());
		theatreEntity.setMovieEntity(movieEntity);
		System.out.println(theatreEntity.getMovieEntity().getMovieName());
		theatreRepository.save(theatreEntity);
		System.out.println(theatreEntity.getLocation());
		return theatreEntity.getTheatreName();
	}

	@Override
	public String deleteTheatre(Integer theatreId) {
		TheatreEntity theatreEntity=entitymanger.find(TheatreEntity.class, theatreId);
		theatreEntity.setMovieEntity(null);
//		entitymanager.remove(theatreEntity);
		theatreRepository.delete(theatreEntity);
		return theatreEntity.getTheatreName();
	}

	@Override
	public String updateMovieId(Integer theatreId, Integer movieId) {
		TheatreEntity theatreEntity = entitymanger.find(TheatreEntity.class, theatreId);
		MovieEntity movieEntity= entitymanger.find(MovieEntity.class, movieId);
		theatreEntity.setMovieEntity(movieEntity);
//		entitymanager.persist(theatreEntity);
		theatreRepository.save(theatreEntity);
		return theatreEntity.getTheatreName();
	}

	@Override
	public String addNewShow(Integer theatreId,Show show) {
		ShowEntity showentity= new ShowEntity();
		TheatreEntity theatreEntity=entitymanger.find(TheatreEntity.class, theatreId);
		System.out.println(theatreEntity.getTheatreName());
		showentity.setSeatCapacity(show.getSeatCapcity());
		showentity.setShowDate(show.getShowDate());
		showentity.setShowTime(show.getShowTime());
		showentity.setTheatreEntity(theatreEntity);
		showRepository.save(showentity);
		System.out.println(showentity.getShowId());
		return showentity.getTheatreEntity().getTheatreName();
	}

}
