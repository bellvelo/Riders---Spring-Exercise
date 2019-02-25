package com.bellvelo.example.bikes.controllers;


import com.bellvelo.example.bikes.models.Race;
import com.bellvelo.example.bikes.repositories.Race.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/races")
//@RequestMapping( "/api")
public class RaceController {

    @Autowired
    RaceRepository raceRepository;

//    @GetMapping
//    public List<Race> getAllRaces(){
//        return raceRepository.findAll();
//    }
//
//    @GetMapping("{id}")
//    public Optional<Race> getRace(@PathVariable Long id){
//        return raceRepository.findById(id);
//    }

    @GetMapping("of/{country}")
    public List<Race> getRace(@PathVariable String country){
        return raceRepository.getRacesFromCountry(country);
    }

}
