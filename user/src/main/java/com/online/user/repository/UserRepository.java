package com.online.user.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.user.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
	
	UserEntity findAllByuserName(String username);

}
