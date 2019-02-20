package com.bellvelo.example.bikes.repositories.Rider;


import com.bellvelo.example.bikes.models.Rider;

import java.util.List;

public interface RiderRepositoryCustom {
    List<Rider> getRidersOverAge(int age);
}
