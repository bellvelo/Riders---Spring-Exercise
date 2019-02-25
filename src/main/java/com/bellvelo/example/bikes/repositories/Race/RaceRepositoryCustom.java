package com.bellvelo.example.bikes.repositories.Race;

import com.bellvelo.example.bikes.models.Race;

import java.util.List;

public interface RaceRepositoryCustom {
    List<Race> getRacesFromCountry(String country);
}
