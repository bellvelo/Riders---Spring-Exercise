package com.bellvelo.example.bikes.controllers;



import com.bellvelo.example.bikes.models.Team;
import com.bellvelo.example.bikes.repositories.Team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/teams")  // sets the base URL
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Team> getTeam(@PathVariable Long id){
        return teamRepository.findById(id);
    }

    @GetMapping("from/{nationality}")
    public List<Team> getTeam(@PathVariable String nationality){
        return teamRepository.getTeamsByNation(nationality);
    }
}