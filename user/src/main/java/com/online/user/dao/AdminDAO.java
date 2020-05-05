package com.online.user.dao;

import com.online.user.model.User;

public interface AdminDAO {
	public User getAdminFromDB(String username);

}
