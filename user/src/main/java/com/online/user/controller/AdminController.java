package com.online.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.online.user.model.User;
import com.online.user.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
@ComponentScan("com.online.user.*")
public class AdminController {
	@Autowired
	private AdminService adminService;
//	private UserRepository userRepository;


	@PostMapping("/login")
	public ResponseEntity<User> validateAdminCredentials(@RequestBody User user) throws Exception {
		try {
			User userResponse = adminService.autenticateAdminCredentials(user.getUsername(), user.getPassword());
			
			if(userResponse!=null){
				return 	new ResponseEntity<User>(userResponse, HttpStatus.ACCEPTED);
			}
			else {
				throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
			}		
		}catch (Exception e) {
			User userWithError = new User();
			userWithError.setErrorMessage("admin authentication failed");
			return new ResponseEntity<User>(userWithError, HttpStatus.BAD_REQUEST);
		}
	

}
}
