package com.online.booking.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.booking.Entity.ShowEntity;


@Repository
public interface ShowRepository extends CrudRepository<ShowEntity, Integer> {
	

}
