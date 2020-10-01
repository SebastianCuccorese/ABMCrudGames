package com.example.accessingdatamysql;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Company {
    public Company() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String companyName;

    private String email;
    @OneToMany(mappedBy = "dev")
    private List<Games> games = new ArrayList<>();
    @OneToMany(mappedBy = "company" )
    private List<Person> person = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Games> getGames() {
        return games;
    }

    public void setGames(List<Games> games) {
        this.games = games;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

