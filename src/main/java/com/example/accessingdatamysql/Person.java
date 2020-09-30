package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer Id;
    private String name;
    private Integer cellphoneNro;

    @ManyToOne
    private Company company;

}
