package com.bellvelo.example.bikes.projections;

import com.bellvelo.example.bikes.models.Race;
import com.bellvelo.example.bikes.models.Rider;
import com.bellvelo.example.bikes.models.Team;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedTeam", types = Rider.class)
public interface EmbedTeam {
    Long getId();
    String getName();
    String getNationality();
    int getAge();
    Team getTeam();
    List<Race> getRaces();
}
