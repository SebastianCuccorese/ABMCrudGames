package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer Id;
    private String name;
    private String surname;
    private Integer cellphoneNro;

    public Person() {
    }

    @ManyToOne
    private Company company;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getCellphoneNro() {
        return cellphoneNro;
    }

    public void setCellphoneNro(Integer cellphoneNro) {
        this.cellphoneNro = cellphoneNro;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

