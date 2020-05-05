package com.online.theatre.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.theatre.DAO.TheatreDAO;
import com.online.theatre.model.Show;
import com.online.theatre.model.Theatre;

@Service(value="theatreService")
@Transactional
public class TheatreServiceImpl implements TheatreService {
	
	@Autowired
	private TheatreDAO theatreDAO;

	@Override
	public List<Theatre> viewAllTheatre(Integer movieId) throws Exception {
		List<Theatre> theatreList = theatreDAO.getTheatresByMovie(movieId);
		if(theatreList.isEmpty()) {
			throw new Exception("no theatre with this movie");
		}
		else {
			return theatreList;
		}
		
	}

	@Override
	public List<Show> viewAllShow(Integer theatreId) throws Exception {
		List<Show> showList = theatreDAO.getShowByTheatre(theatreId);
		System.out.println(showList.size());
		if(showList.isEmpty()) {
			throw new Exception("no shows from this theatre");
		}
		else {
			return showList;
		}
	}

	@Override
	public String addNewTheatre(Theatre theatre) throws Exception {
		String message= theatreDAO.addNewTheatre(theatre);
		if(message!=null) {
			return message+" theatre is added";
		}
		else throw new Exception("movie not added");
	}

	@Override
	public String deleteTheatre(Integer theatreId) throws Exception {
		String message = theatreDAO.deleteTheatre(theatreId);
		if(message!=null) {
			return message +" theatre is deleted";
		}
		else throw new Exception("no theatre found");
	}

	@Override
	public String updateMovieDetails(Integer theatreId, Integer movieId) throws Exception {
		String message= theatreDAO.updateMovieId(theatreId, movieId);
		if(message!=null) {
			return message+" movie details updated";
		}
		else throw new Exception("no theatre found");
	}

	@Override
	public String addNewShow(Integer theatreId, Show show) throws Exception {
		String message= theatreDAO.addNewShow(theatreId, show);
		if(message!=null) {
			return message +" Show added successfully";
		}
		else throw new Exception("no theare found");
	}

	@Override
	public List<Theatre> viewAllTheatre() throws Exception {
		List<Theatre> theatreList = theatreDAO.getAllTheatre();
		if(theatreList.isEmpty()) {
			throw new Exception("no theatres");
		}
		else {
			return theatreList;
		}
	}

}
