package com.bellvelo.example.bikes.models;

import javax.persistence.Id;

import javax.persistence.*;


@Entity
@Table(name = "riders")
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // this allows Hibernate to map the property to the primary key column of a database table.
    @Column(name="name")
    private String name;
    @Column(name="nationality")
    private String Nationality;
    @Column(name="age")
    private int age;

    public Rider(String name, String nationality, int age) {
        this.name = name;
        Nationality = nationality;
        this.age = age;
    }

    public Rider() {   // All Java classes that will be mapped need a default/empty constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
