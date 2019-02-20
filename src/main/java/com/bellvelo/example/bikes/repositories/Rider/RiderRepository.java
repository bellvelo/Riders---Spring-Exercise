package com.bellvelo.example.bikes.repositories.Rider;

import com.bellvelo.example.bikes.models.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long>, RiderRepositoryCustom {
}
