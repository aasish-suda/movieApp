package com.online.user.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.user.entity.UserEntity;
import com.online.user.model.User;

@Repository(value="adminDAO")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public User getAdminFromDB(String username) {
		UserEntity userEntity=entityManager.find(UserEntity.class, username);
//		System.out.println(userEntity.getRole());
		if(userEntity.getRole().equals("A")) {
			User user= new User();
			user.setUsername(userEntity.getUserName());
			user.setEmail(userEntity.getEmail());
			user.setPassword(userEntity.getPassword());
//			user.setPhone(userEntity.getPhone());
//			System.out.println(user.getUsername());
			return user;
			
		}
		return null;
	}

}
