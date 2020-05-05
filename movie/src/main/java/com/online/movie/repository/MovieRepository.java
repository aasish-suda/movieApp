package com.online.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.movie.entity.MovieEntity;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
	
	MovieEntity findAllBymovieName(String movieName);

}
