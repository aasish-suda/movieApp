package com.online.theatre.Service;

import java.util.List;

import com.online.theatre.model.Show;
import com.online.theatre.model.Theatre;

public interface TheatreService {
	public List<Theatre> viewAllTheatre(Integer movieId) throws Exception;
	public List<Show> viewAllShow(Integer theatreId) throws Exception;
	public String addNewTheatre(Theatre theatre) throws Exception;
	public String deleteTheatre(Integer theatreId) throws Exception;
	public String updateMovieDetails(Integer theatreId, Integer movieId) throws Exception;
	public String addNewShow(Integer theatreId, Show show) throws Exception;
	
	
	

}
