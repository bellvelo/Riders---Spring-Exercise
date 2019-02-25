package com.bellvelo.example.bikes.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "race_name")
    private String race_name;

    @Column(name = "country")
    private String country;

    @Column(name = "tour_ranking")
    private String tour_ranking;

    @Column(name = "prize_money")
    private double prize_money;

    @JsonIgnore
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "riders_races",
            joinColumns = {@JoinColumn(name = "race_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="rider_id", nullable = false, updatable = false)}
    )
    private List<Rider> riders;

    public Race(String race_name, String country, String tour_ranking, double prize_money) {
        this.race_name = race_name;
        this.country = country;
        this.tour_ranking = tour_ranking;
        this.prize_money = prize_money;
        this.riders = new ArrayList<Rider>();
    }

    public Race(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRace_name() {
        return race_name;
    }

    public void setRace_name(String race_name) {
        this.race_name = race_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTour_ranking() {
        return tour_ranking;
    }

    public void setTour_ranking(String tour_ranking) {
        this.tour_ranking = tour_ranking;
    }

    public double getPrize_money() {
        return prize_money;
    }

    public void setPrize_money(double prize_money) {
        this.prize_money = prize_money;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }

    public void addRiderToRace(Rider rider){
        this.riders.add(rider);
    }
}
