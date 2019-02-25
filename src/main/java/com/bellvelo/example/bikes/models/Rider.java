package com.bellvelo.example.bikes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="team_id", nullable = false)
    private Team team;

    @JsonIgnore
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "riders_races",
            joinColumns = {@JoinColumn(name = "rider_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "race_id", nullable = false, updatable = false)}
    )
    private List<Race> races;


    public Rider(String name, String nationality, int age, Team team) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.team = team;
        this.races = new ArrayList<Race>();
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

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
