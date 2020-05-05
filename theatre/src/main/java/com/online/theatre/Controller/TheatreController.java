package com.online.theatre.Controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.theatre.Service.TheatreService;
import com.online.theatre.model.Movie;
import com.online.theatre.model.Show;
import com.online.theatre.model.Theatre;


@CrossOrigin
@RestController
@RequestMapping("/theatre")
@ComponentScan("com.online.thetre.*")
public class TheatreController {

	@Autowired
	private TheatreService theatreService;
	
	@PostMapping("/getTheatre{movieId}")
	public ResponseEntity<List<Theatre>> getAllTheatresByMovie(@PathParam(value="movieId") Integer movieId) throws Exception{
//		System.o/t.println(movieName+"from API");
		try {
			List<Theatre> theatreList	= theatreService.viewAllTheatre(movieId);
			return new ResponseEntity<List<Theatre>>(theatreList,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			List<Theatre> errorList= new ArrayList<Theatre>();
			Theatre theatre= new Theatre();
			theatre.setErrorMessage(e.getLocalizedMessage());
			errorList.add(theatre);
			return new ResponseEntity<List<Theatre>>(errorList,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/getShow{theatreId}")
	public ResponseEntity<List<Show>> getAllShowByTheatre(@PathParam(value="theatreId") Integer theatreId) throws Exception{
		System.out.println(theatreId+"API");
		try {
			List<Show> showList	= theatreService.viewAllShow(theatreId);
			return new ResponseEntity<List<Show>>(showList,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			List<Show> errorList= new ArrayList<Show>();
			Show show= new Show();
			show.setErrorMesssage(e.getLocalizedMessage());
			errorList.add(show);
			return new ResponseEntity<List<Show>>(errorList,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addTheatre")
	public ResponseEntity<String> addNewTheatre(@RequestBody Theatre theatre){
		try {
			System.out.println(theatre.getTheatreName());
			String message= theatreService.addNewTheatre(theatre);
			System.out.println(message);
			return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
			
		}catch (Exception e) {
			String errorMessage = e.getLocalizedMessage();
			return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PutMapping("/updateTheatre{theatreId}")
	public ResponseEntity<String> updateMovieDetails(@PathParam(value="theatreId") Integer theatreId,@RequestBody Movie movie){
		try {
			String message= theatreService.updateMovieDetails(theatreId, movie.getMovieId());
			return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
		}catch (Exception e) {
			String errorMessage = e.getLocalizedMessage();
			return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_GATEWAY);
		}
		
	}
	@DeleteMapping("/deleteTheatre")
	public ResponseEntity<String> removeTheatreDetails(@PathParam(value="theatreId") Integer theatreId){
		try {
			String message= theatreService.deleteTheatre(theatreId);
			return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
		}catch (Exception e) {
			String errorMessage = e.getLocalizedMessage();
			return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PostMapping("/addShow")
	public ResponseEntity<String> addNewShow(@PathParam(value="theatreId") Integer theatreId,@RequestBody Show show){
		try {
			String message= theatreService.addNewShow(theatreId, show);
			return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
		}catch (Exception e) {
			String errorMessage = e.getLocalizedMessage();
			return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_GATEWAY);
		}
		
	}
	@GetMapping("/viewAll")
	public ResponseEntity<List<Theatre>> getAllTheatres() throws Exception{
		try {
			List<Theatre> theatreList	= theatreService.viewAllTheatre();
			return new ResponseEntity<List<Theatre>>(theatreList,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			List<Theatre> errorList= new ArrayList<Theatre>();
			Theatre theatre= new Theatre();
			theatre.setErrorMessage(e.getLocalizedMessage());
			errorList.add(theatre);
			return new ResponseEntity<List<Theatre>>(errorList,HttpStatus.NOT_FOUND);
		}
	}
}
