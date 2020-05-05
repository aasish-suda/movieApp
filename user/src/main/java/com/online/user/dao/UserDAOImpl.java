package com.online.user.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.online.user.entity.UserEntity;
import com.online.user.model.User;

@Repository(value="userDAO")
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager enititymanager;

	@Override
	public User getPasswordFromDB(String username) {
		UserEntity userEntity = enititymanager.find(UserEntity.class, username);
		User user =new User();
		user.setUsername(userEntity.getUserName());
		user.setEmail(userEntity.getEmail());
		user.setPhone(userEntity.getPhone());
		user.setPassword(userEntity.getPassword());
		return user;
	}

	@Override
	public User addNewUserToDB(User user) {
		if(enititymanager.find(UserEntity.class, user.getUsername())==null) {
			UserEntity userEntity= new UserEntity();
			userEntity.setUserName(user.getUsername());
			userEntity.setEmail(user.getEmail());
			userEntity.setPassword(user.getPassword());
			userEntity.setPhone(user.getPhone());
			userEntity.setRole("U");
			
			enititymanager.persist(userEntity);
			user.setPassword(null);
			user.setPhone(null);
			return user;
		}
		return null;
	}

}
