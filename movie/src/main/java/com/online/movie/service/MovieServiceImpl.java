package com.online.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.movie.dao.MovieDAO;
import com.online.movie.model.Movie;


@Service(value="movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDAO movieDAO;

	@Override
	public Movie findMovieByName(String movieName) throws Exception {
		Movie movieFound= movieDAO.searchMovieInDB(movieName);
		if(movieFound!=null) {
			return movieFound;
		}
		else throw new Exception("Movie Not found");
	}

	@Override
	public List<Movie> findAllMovie() throws Exception {
		List<Movie> movieList = movieDAO.viewAllMovieFromDB();
		if(movieList!=null) {
			return movieList;
		}
		else throw new Exception("no movies present");
	}

	@Override
	public String addNewMovie(Movie movie) throws Exception {
		String message=movieDAO.addMovieToDB(movie);
		if(message!=null){
			return message;
		}
		else throw new Exception("movie not added");
	}

	@Override
	public String updateMovierating(Movie movie) throws Exception {
		String message=movieDAO.updateMovieRating(movie.getMovieId(), movie.getRating());
		if(message!=null){
			return message;
		}
		else throw new Exception("rating not updated");
	}

	@Override
	public String removeMovie(Movie movie) throws Exception {
		String message=movieDAO.delMovieFromDB(movie.getMovieId());
		if(message!=null){
			return message;
		}
		else throw new Exception("movie not deleted");
	}

}
