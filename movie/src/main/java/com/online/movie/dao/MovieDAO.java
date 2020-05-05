package com.online.movie.dao;

import java.util.List;

import com.online.movie.model.Movie;

public interface MovieDAO {
	public Movie searchMovieInDB(String movieName);
	public List<Movie> viewAllMovieFromDB();
	public String addMovieToDB(Movie movie);
	public String updateMovieRating(Integer movieId,Integer rating);
	public String delMovieFromDB(Integer movieIdd);

}
