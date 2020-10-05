package com.example.accessingdatamysql;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "dev")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private Set<Games> gamesList;
    @OneToMany(mappedBy = "company")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private Set<Person> personList;


    public Company() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Games> getGamesList() {
        return gamesList;
    }

    public void setGamesList(Set<Games> gamesList) {
        this.gamesList = gamesList;
    }

    public void setPersonList(Set<Person> personList) {
        this.personList = personList;
    }

    public void addGames(Games games) {
        gamesList.add(games);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Person> getPerson() {
        return personList;
    }
    public void addPerson(Person person) {
        personList.add(person);
    }
}

