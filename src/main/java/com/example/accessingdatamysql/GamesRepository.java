package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GamesRepository extends CrudRepository<Games, Integer> {
    List<Games> findByName(String name);
    List<Games> findByDev_CompanyName(String companyName);
}

