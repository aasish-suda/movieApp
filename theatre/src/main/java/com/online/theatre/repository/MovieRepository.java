package com.online.theatre.repository;

import org.springframework.data.repository.CrudRepository;

import com.online.theatre.entity.MovieEntity;

public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {

}
