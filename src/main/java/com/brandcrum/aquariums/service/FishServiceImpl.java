package com.brandcrum.aquariums.service;

import com.brandcrum.aquariums.common.builder.FishBuilder;
import com.brandcrum.aquariums.common.builder.FishDTOBuilder;
import com.brandcrum.aquariums.common.builder.TankDTOBuilder;
import com.brandcrum.aquariums.common.dto.FishDTO;
import com.brandcrum.aquariums.model.Fish;
import com.brandcrum.aquariums.model.Tank;
import com.brandcrum.aquariums.repository.FishRepository;
import com.brandcrum.aquariums.repository.TankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
/**
 * Created by jadiaz on 30/04/18.
 */
@Service
public class FishServiceImpl implements FishService{

    private static Logger LOG = LoggerFactory.getLogger(FishServiceImpl.class);

    @Autowired
    private FishRepository fishRepository;

    @Autowired
    private TankRepository tankRepository;

    @Override
    @Transactional
    public Optional<Long> create(FishDTO fishDTO) {
        try {
            Fish fish = new FishBuilder(fishDTO).build();
            Optional<Tank> tank = tankRepository.findById(fishDTO.getTank());
            if (tank.isPresent()) {
                fish.setTank(tank.get());
                fish.setCreationDate(LocalDateTime.now());
                fish = fishRepository.save(fish);
                if (Objects.isNull(fish)) return Optional.empty();
                else return Optional.of(fish.getId());
            } else return Optional.empty();
        } catch (DataAccessException exception) {
            LOG.error("Ha habido una excepción guardando la entidad Fish:: " + exception.getMessage());
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<FishDTO> findById(Long id) {
        Optional<Fish> fish = fishRepository.findById(id);
        if (fish.isPresent()) {
            return Optional.of(new FishDTOBuilder(fish.get()).build());
        }
        return Optional.empty();
    }

    @Override
    public void update(FishDTO fishDTO) {
        //Not implemented
    }

    @Override
    @Transactional
    public void delete(Long fishId) {
        fishRepository.deleteById(fishId);
    }
}
