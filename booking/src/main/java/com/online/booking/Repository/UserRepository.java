package com.online.booking.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.booking.Entity.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
	
	UserEntity findAllByuserName(String username);

}
