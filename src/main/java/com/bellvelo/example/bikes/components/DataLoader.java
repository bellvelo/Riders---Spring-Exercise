package com.bellvelo.example.bikes.components;


import com.bellvelo.example.bikes.models.Race;
import com.bellvelo.example.bikes.models.Rider;
import com.bellvelo.example.bikes.models.Team;
import com.bellvelo.example.bikes.repositories.Race.RaceRepository;
import com.bellvelo.example.bikes.repositories.Rider.RiderRepository;
import com.bellvelo.example.bikes.repositories.Team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    RiderRepository riderRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RaceRepository raceRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        DateFormat sfd = new SimpleDateFormat("dd-MM-yy");
        String newDate = "24-07-2018";
        Date date = null;
        try {
            date = sfd.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Team lotto = new Team("Lotto Soudal", "BEL", 4, 2000);
        teamRepository.save(lotto);
        Team quick_step = new Team("Quick-Step", "BEL", 1, 5000);
        teamRepository.save(quick_step);
        Team credit_agricole = new Team("Credit-Agricole", "FRA", 8, 800);
        teamRepository.save(credit_agricole);

        Rider greg = new Rider("Greg Van Avramat", "BEL", 28, lotto);
        riderRepository.save(greg);
        Rider adam = new Rider("Adam Blythe", "UK", 29, lotto);
        riderRepository.save(adam);
        Rider tibaut = new Rider("Tibaut Pinot", "FRA", 23, credit_agricole);
        riderRepository.save(tibaut);
        Rider marcel = new Rider("Marcel Kittel", "GER", 24, quick_step);
        riderRepository.save(marcel);

        Race tour_de_france = new Race("Tour de France", "FRA", "WorldTour", 5000);
        raceRepository.save(tour_de_france);
        Race giro = new Race("Giro d'Italia", "ITA", "WorldTour", 4000);
        raceRepository.save(giro);
        Race vuelta = new Race("Vuelta Espana", "SPA", "WorldTour", 3000);
        raceRepository.save(vuelta);

        tour_de_france.addRiderToRace(greg);
        raceRepository.save(tour_de_france);
        giro.addRiderToRace(greg);
        raceRepository.save(giro);

        giro.addRiderToRace(adam);
        raceRepository.save(giro);

        vuelta.addRiderToRace(tibaut);
        raceRepository.save(vuelta);

        tour_de_france.addRiderToRace(marcel);
        raceRepository.save(tour_de_france);

    }
}