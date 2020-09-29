package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

public interface GamesRepository extends CrudRepository<Games, Integer> {

}
