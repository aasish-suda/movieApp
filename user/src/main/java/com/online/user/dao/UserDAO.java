package com.online.user.dao;

import com.online.user.model.User;

public interface UserDAO {
	public User getPasswordFromDB(String username);
	public User addNewUserToDB(User user);

}
