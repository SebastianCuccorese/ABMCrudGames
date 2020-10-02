package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByName(String name);
    List<Person> findBySurname(String surname);
    List<Person> findByNameAndSurname(String name, String surname);
    List<Person> findByCompany_CompanyName(String companyName);
}

