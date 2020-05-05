package com.online.theatre.repository;

import org.springframework.data.repository.CrudRepository;

import com.online.theatre.entity.ShowEntity;

public interface ShowRepository extends CrudRepository<ShowEntity, Integer> {

}
