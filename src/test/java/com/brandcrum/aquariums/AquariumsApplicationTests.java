package com.brandcrum.aquariums;

import com.brandcrum.aquariums.repository.FishRepository;
import com.brandcrum.aquariums.repository.TankRepository;
import com.brandcrum.aquariums.service.FishService;
import com.brandcrum.aquariums.service.TankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


@ComponentScan(basePackageClasses = {
		FishService.class,
		TankService.class,
		TankRepository.class,
		FishRepository.class
})
@RunWith(SpringRunner.class)
@SpringBootTest
public class AquariumsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
