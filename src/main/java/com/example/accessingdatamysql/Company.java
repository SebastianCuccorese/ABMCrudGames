package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "dev")
    private List<Games> gamesList = new ArrayList<>();
    @OneToMany(mappedBy = "company" )
    private List<Person> personList = new ArrayList<>();

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

    public List<Games> getGamesList() {
        return gamesList;
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

    public List<Person> getPerson() {
        return personList;
    }
    public void addPerson(Person person) {
        personList.add(person);
    }
}

