package com.online.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.user.dao.AdminDAO;
import com.online.user.model.User;

@Service(value="adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO adminDAO;
	@Override
	public User autenticateAdminCredentials(String username, String password) throws Exception {
		User user= adminDAO.getAdminFromDB(username);
		if(user!=null && user.getPassword().equals(password)) {
			user.setPassword(null);
				return user;
			}
			else {
				throw new Exception("no user found with this username");
			}
	}

}
