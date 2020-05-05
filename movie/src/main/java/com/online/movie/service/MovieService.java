package com.online.movie.service;

import java.util.List;

import com.online.movie.model.Movie;

public interface MovieService {
	public Movie findMovieByName(String movieName) throws Exception;
	public List<Movie> findAllMovie() throws Exception;
	public String addNewMovie(Movie movie) throws Exception;
	public String updateMovierating(Movie movie) throws Exception;
	public String removeMovie(Movie movie) throws Exception;
	

}
