package com.bellvelo.example.bikes;

import com.bellvelo.example.bikes.repositories.Rider.RiderRepository;
import com.bellvelo.example.bikes.repositories.Team.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BikesApplicationTests {

    @Autowired
    RiderRepository riderRepository;
    TeamRepository teamRepository;


	@Test
	public void contextLoads() {
	}


}
