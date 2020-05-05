package com.online.user.service;

import com.online.user.model.User;

public interface UserService {
	public User authenticateUserCredentials(String username, String password) throws Exception;
	public User registerNewUser(User user) throws Exception;

}
