package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CompanyRepository extends CrudRepository<Company, Integer> {
    //@Query("SELECT m FROM Company m WHERE m.companyName LIKE %:title%")
    //List<Company> searchByNameLike(@Param("name") String name);

    List<Company> findByCompanyName(String name);

}
