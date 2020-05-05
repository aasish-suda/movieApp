package com.online.theatre.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.theatre.entity.ShowEntity;

@Repository
public interface ShowRepository extends CrudRepository<ShowEntity, Integer> {
	

}
