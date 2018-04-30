package com.brandcrum.aquariums.service;

import com.brandcrum.aquariums.common.builder.TankDTOBuilder;
import com.brandcrum.aquariums.common.dto.TankDTO;
import com.brandcrum.aquariums.model.Tank;
import com.brandcrum.aquariums.repository.FishRepository;
import com.brandcrum.aquariums.repository.TankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jadiaz on 30/04/18.
 */
@Service
public class TankServiceImpl implements TankService {

    @Autowired
    private TankRepository tankRepository;

    @Autowired
    private FishRepository fishRepository;

    @Override
    public Optional<Long> create(TankDTO tankDTO) {
        return null;
    }

    @Override
    public Optional<TankDTO> findById(Long id) {
        Optional<Tank> tank = tankRepository.findById(id);
        if (tank.isPresent()) {
            return Optional.of(new TankDTOBuilder(tank.get(), fishRepository.findAllByTankId(id)).build());
        }
        return Optional.empty();
    }

    @Override
    public void update(TankDTO tankDTO) {

    }

    @Override
    public void delete(Long tankId) {

    }
}
