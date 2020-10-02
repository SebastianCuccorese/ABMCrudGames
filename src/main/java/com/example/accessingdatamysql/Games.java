package com.example.accessingdatamysql;


import javax.persistence.*;
import java.sql.Time;

@Entity
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String name;

    private String genre;

    private double hoursAmount;

    private Integer missionsAmount;

    @ManyToOne
    private Company dev;

    public Games() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getDev() {
        return dev;
    }

    public void setDev(Company dev) {
        this.dev = dev;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getHoursAmount() {
        return hoursAmount;
    }

    public void setHoursAmount(double hoursAmount) {
        this.hoursAmount = hoursAmount;
    }

    public Integer getMissionsAmount() {
        return missionsAmount;
    }

    public void setMissionsAmount(Integer missionsAmount) {
        this.missionsAmount = missionsAmount;
    }
}
