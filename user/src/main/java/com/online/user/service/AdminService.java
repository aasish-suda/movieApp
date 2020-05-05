package com.online.user.service;

import com.online.user.model.User;

public interface AdminService {
	public User autenticateAdminCredentials(String username, String password) throws Exception;

}
