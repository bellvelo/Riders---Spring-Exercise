package com.bellvelo.example.bikes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "riders")
public class Rider {

    @Column(name="name")
    private String name;

    @Column(name="nationality")
    private String nationality;

    @Column(name="age")
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="team_id", nullable = false)
    private Team team;

    public Rider(String name, String nationality, int age, Team team) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.team = team;
    }

    public Rider() {
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
        return nationality;
    }

    public void setNationality(String nationality) {
        nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
