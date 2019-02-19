package com.bellvelo.example.bikes;

import com.bellvelo.example.bikes.models.Rider;
import com.bellvelo.example.bikes.repositories.RiderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BikesApplicationTests {

    @Autowired
    RiderRepository riderRepository; //dependency njection


	@Test
	public void contextLoads() {
	}

    @Test
    public void createRider(){
	    Rider david = new Rider("David", "UK", 44);
	    riderRepository.save(david);
    }


}
