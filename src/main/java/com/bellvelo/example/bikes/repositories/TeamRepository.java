package com.bellvelo.example.bikes.repositories;

import com.bellvelo.example.bikes.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
