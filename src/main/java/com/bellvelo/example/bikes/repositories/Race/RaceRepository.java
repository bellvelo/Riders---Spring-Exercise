package com.bellvelo.example.bikes.repositories.Race;


import com.bellvelo.example.bikes.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> , RaceRepositoryCustom{
}
