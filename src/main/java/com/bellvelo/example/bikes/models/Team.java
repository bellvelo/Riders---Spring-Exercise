package com.bellvelo.example.bikes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Column(name = "team_name")
    private String team_name;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "tour_rank")
    private int tour_rank;

    @Column(name = "tour_points")
    private int tour_points;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
    @JsonIgnore
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Rider> riders;

    public Team(String team_name, String nationality, int tour_rank, int tour_points) {
        this.team_name = team_name;
        this.nationality = nationality;
        this.tour_rank = tour_rank;
        this.tour_points = tour_points;
        this.riders = new ArrayList<Rider>();
    }

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getTour_rank() {
        return tour_rank;
    }

    public void setTour_rank(int tour_rank) {
        this.tour_rank = tour_rank;
    }

    public int getTour_points() {
        return tour_points;
    }

    public void setTour_points(int tour_points) {
        this.tour_points = tour_points;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }
}
