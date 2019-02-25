package com.bellvelo.example.bikes.repositories.Rider;

import com.bellvelo.example.bikes.models.Rider;

import com.bellvelo.example.bikes.projections.EmbedTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(excerptProjection = EmbedTeam.class)
public interface RiderRepository extends JpaRepository<Rider, Long>, RiderRepositoryCustom {
}
