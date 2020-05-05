package com.online.movie.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.movie.entity.MovieEntity;
import com.online.movie.model.Movie;
import com.online.movie.repository.MovieRepository;

@Repository(value="movieDAO")
public class MovieDAOImpl implements MovieDAO {
	@Autowired
	private MovieRepository movieRepository;
	
	@PersistenceContext
	private EntityManager entitymanger;

	@Override
	public Movie searchMovieInDB(String movieName) {
		MovieEntity movieEntityFromDB = movieRepository.findAllBymovieName(movieName);
		if(movieEntityFromDB!=null) {
			System.out.println(movieEntityFromDB.getMovieName());
			Movie movie= new Movie();
			movie.setMovieId(movieEntityFromDB.getMovieId());
			movie.setMovieName(movieEntityFromDB.getMovieName());
			movie.setGenre(movieEntityFromDB.getGenre());
			movie.setRating(movieEntityFromDB.getRating());	
			return movie;
		}
		return null;
	}

	@Override
	public List<Movie> viewAllMovieFromDB() {
		List<Movie> movieList= new ArrayList<Movie>();
		List<MovieEntity> listFromDB = (List<MovieEntity>) movieRepository.findAll();
		if(listFromDB!=null) {
			for (MovieEntity movieEntity:listFromDB) {
				Movie movie= new Movie();
				movie.setMovieId(movieEntity.getMovieId());
				movie.setMovieName(movieEntity.getMovieName());
				movie.setGenre(movieEntity.getGenre());
				movie.setRating(movieEntity.getRating());
				movieList.add(movie);
			}
			return movieList;
		}
		
		return null;
	}

	@Override
	public String addMovieToDB(Movie movie) {
		MovieEntity movieEntity= new MovieEntity();
		movieEntity.setMovieName(movie.getMovieName());
		movieEntity.setGenre(movie.getGenre());
		movieEntity.setRating(movie.getRating());
		movieRepository.save(movieEntity);
		return movieEntity.getMovieName()+" is added successfully";
	}

	@Override
	public String updateMovieRating(Integer movieId,Integer rating) {
		MovieEntity movieEntity = entitymanger.find(MovieEntity.class, movieId);
		if(movieEntity!=null) {
		movieEntity.setRating(rating);
		entitymanger.detach(movieEntity);
		movieRepository.save(movieEntity);
		return movieEntity.getMovieName()+" is updated successfully";
		}
		else {
			return null;
		}
	}

	@Override
	public String delMovieFromDB(Integer movieId) {
		MovieEntity movieEntity= entitymanger.find(MovieEntity.class, movieId);
		if(movieEntity!=null) {
			movieRepository.delete(movieEntity);
			return movieEntity.getMovieName()+" is deleted successfully";
		}
		else return null;
	}


}
