package com.online.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.user.dao.UserDAO;
import com.online.user.model.User;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public User authenticateUserCredentials(String username, String password) throws Exception {
        User userEntityFromDB= userDAO.getPasswordFromDB(username);
        if(password.equals(userEntityFromDB.getPassword())) {
        	User user =new User();
        	user.setUsername(userEntityFromDB.getUsername());
        	user.setEmail(userEntityFromDB.getEmail());
        	return user;
        }
        else 
        	throw new Exception("no user found with this username");
	}

	@Override
	public User registerNewUser(User user) throws Exception {
		if(userDAO.addNewUserToDB(user).equals(null)) {
			throw new Exception("user name already exist");
		}
		else return user;
	}

}
