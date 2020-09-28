package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;


public interface DeveloperRepository extends CrudRepository<Developer, Integer> {

}