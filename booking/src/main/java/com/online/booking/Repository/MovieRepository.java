package com.online.booking.Repository;

import org.springframework.data.repository.CrudRepository;

import com.online.booking.Entity.MovieEntity;

public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {

}
