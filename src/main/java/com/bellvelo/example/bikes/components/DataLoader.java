package com.bellvelo.example.bikes.components;


import com.bellvelo.example.bikes.models.Rider;
import com.bellvelo.example.bikes.models.Team;
import com.bellvelo.example.bikes.repositories.RiderRepository;
import com.bellvelo.example.bikes.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    RiderRepository riderRepository;

    @Autowired
    TeamRepository teamRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

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
        Rider marcel = new Rider("Marcel Kittel", "GER", 27, quick_step);
        riderRepository.save(marcel);



    }
}