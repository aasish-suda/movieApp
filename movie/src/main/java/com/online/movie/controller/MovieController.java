package com.online.movie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.movie.model.Movie;
import com.online.movie.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping("/movie")
@ComponentScan("com.online.movie.*")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@PostMapping(value="/search{moviename}")
	public ResponseEntity<Movie> searchMovie(@PathParam (value="moviename")String moviename) throws Exception{
		try {
			System.out.println(moviename);
			Movie movie =movieService.findMovieByName(moviename);
			return new ResponseEntity<Movie>(movie,HttpStatus.FOUND);
			
		}catch (Exception e) {
			Movie movieError= new Movie();
			movieError.setErrorMessage("Movie not found");
			return  new ResponseEntity<Movie>(movieError,HttpStatus.NOT_FOUND);
		}
		
		
	}
	@GetMapping(value="/viewAll")
	public ResponseEntity<List<Movie>> getAllMovie() throws Exception{
		try {
			List<Movie> movieList = movieService.findAllMovie();
			return new ResponseEntity<List<Movie>>(movieList, HttpStatus.FOUND);
		}catch (Exception e) {
			List<Movie> movieWithErrorList= new ArrayList<Movie>();
			Movie movieError= new Movie();
			movieError.setErrorMessage("There are no movies");
			movieWithErrorList.add(movieError);
			return  new ResponseEntity<List<Movie>>(movieWithErrorList,HttpStatus.NOT_FOUND);
			
		}
		
	}
	@PostMapping(value="/addMovie")
	public ResponseEntity<String> addNewMovie(@RequestBody Movie movie) throws Exception{
		try {
			String message= movieService.addNewMovie(movie);
			return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			String errorMessage=e.getLocalizedMessage();
			return new ResponseEntity<String>(errorMessage,HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping(value="/updateMovie")
	public ResponseEntity<String> updateMovieRating(@RequestBody Movie movie) throws Exception{
		try {
			String message= movieService.updateMovierating(movie);
			return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			String errorMessage=e.getLocalizedMessage();
			return new ResponseEntity<String>(errorMessage,HttpStatus.BAD_REQUEST);
		}
		
	}
	@DeleteMapping(value="/deleteMovie")
	public ResponseEntity<String> deleteMovie(@RequestBody Movie movie) throws Exception{
		try {
			String message= movieService.removeMovie(movie);
			return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			String errorMessage=e.getLocalizedMessage();
			return new ResponseEntity<String>(errorMessage,HttpStatus.BAD_REQUEST);
		}
		
	}

}
