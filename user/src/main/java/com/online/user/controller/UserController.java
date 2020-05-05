package com.online.user.controller;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//import com.online.user.entity.UserEntity;
import com.online.user.model.User;
//import com.online.user.repository.UserRepository;
import com.online.user.service.UserService;
//import com.online.user.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/user")
@ComponentScan("com.online.user.*")
public class UserController {
	
	@Autowired
	private UserService userService;
//	private UserRepository userRepository;


	@PostMapping("/login")
	public ResponseEntity<User> validateUserCredentials(@RequestBody User user) throws Exception {
		try {
			User userResponse = userService.authenticateUserCredentials(user.getUsername(), user.getPassword());
			
			if(userResponse!=null) {
				
				return 	new ResponseEntity<User>(userResponse, HttpStatus.ACCEPTED);
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}		
		}catch (Exception e) {
			User userWithError = new User();
			userWithError.setErrorMessage("user authentication failed");
			return new ResponseEntity<User>(userWithError, HttpStatus.BAD_REQUEST);
		}

		
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> registerNewUser(@RequestBody User user) throws Exception{
		try {
			User userResponse = userService.registerNewUser(user);
			if(userResponse!=null) {	
				return 	new ResponseEntity<User>(userResponse, HttpStatus.CREATED);
			}	
			
			else throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
			
		}catch (Exception e) {
			User userWithError = new User();
			userWithError.setErrorMessage("user already present");

			return new ResponseEntity<User>(userWithError, HttpStatus.BAD_REQUEST);
		}
		
	}


}
