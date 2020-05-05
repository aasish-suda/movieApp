package com.online.booking.Repository;


//import org.springframework.data.jpa.repository.Query;

//import java.util.List;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import com.online.theatre.entity.MovieEntity;

import com.online.booking.Entity.TheatreEntity;

@Repository
public interface TheatreRepository extends CrudRepository<TheatreEntity, Integer> {
	
}
