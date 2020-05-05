package com.online.theatre.DAO;

import java.util.List;

import com.online.theatre.model.Show;
import com.online.theatre.model.Theatre;

public interface TheatreDAO {

	public List<Theatre> getTheatresByMovie(Integer movieId);
	public List<Show> getShowByTheatre(Integer theatreId);
	public List<Theatre> getAllTheatre();
	public String addNewTheatre(Theatre theatre);
	public String deleteTheatre(Integer theatreId);
	public String updateMovieId(Integer theatreId,Integer movieId);
	public String addNewShow(Integer theatreId,Show show);
}