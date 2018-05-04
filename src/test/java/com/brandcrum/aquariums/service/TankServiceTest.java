package com.brandcrum.aquariums.service;

import com.brandcrum.aquariums.AquariumsApplicationTests;
import com.brandcrum.aquariums.common.dto.TankDTO;
import com.brandcrum.aquariums.common.types.FishType;
import com.brandcrum.aquariums.model.Fish;
import com.brandcrum.aquariums.model.Tank;
import com.brandcrum.aquariums.repository.FishRepository;
import com.brandcrum.aquariums.repository.TankRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jadiaz on 3/05/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AquariumsApplicationTests.class)
public class TankServiceTest {

    @TestConfiguration
    static class TaskServiceImplTestContextConfiguration {

        @Bean
        public TankService tankService() {
            return new TankServiceImpl();
        }
    }

    @Autowired
    private TankService tankService;

    @MockBean
    private FishRepository fishRepository;

    @MockBean
    private TankRepository tankRepository;

    @Before
    public void setUp() {
        Tank tank = new Tank();
        tank.setName("Test 1");
        tank.setVolume(1d);
        tank.setTemperature(1d);

        List<Fish> fishList = new ArrayList<>();
        Fish fish1 = new Fish();
        fish1.setCreationDate(LocalDateTime.now());
        fish1.setName("Fish 1");
        fish1.setPrice(BigDecimal.TEN);
        fish1.setFishType(FishType.SHARK);
        fish1.setTank(tank);
        fishList.add(fish1);

        Fish fish2 = new Fish();
        fish2.setCreationDate(LocalDateTime.now());
        fish2.setName("Fish 2");
        fish2.setPrice(BigDecimal.TEN);
        fish2.setFishType(FishType.SHARK);
        fish2.setTank(tank);
        fishList.add(fish2);

        Mockito.when(tankRepository.findById(1L)).thenReturn(Optional.of(tank));
        Mockito.when(fishRepository.findAllByTankId(1L)).thenReturn(fishList);
    }

    @Test
    public void TankServiceAutowired() {
        assertNotNull(tankService);
    }

    @Test
    public void whenId_thenTankShouldBeFound() {
        Optional<TankDTO> tank = tankService.findById(1l);
        assertTrue(tank.isPresent());
        assertEquals(tank.get().getName(), "Test 1");
        assertEquals(tank.get().getFishDTOS().size(), 2);
    }
}
