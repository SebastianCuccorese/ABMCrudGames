package com.example.accessingdatamysql;


import javax.persistence.*;
import java.sql.Time;

@Entity
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String name;

    private String gender;

    private Time hoursAmount;

    private Integer missionsAmount;

    @ManyToOne
    private Company dev;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Time getHoursAmount() {
        return hoursAmount;
    }

    public void setHoursAmount(Time hoursAmount) {
        this.hoursAmount = hoursAmount;
    }

    public Integer getMissionsAmount() {
        return missionsAmount;
    }

    public void setMissionsAmount(Integer missionsAmount) {
        this.missionsAmount = missionsAmount;
    }
}
