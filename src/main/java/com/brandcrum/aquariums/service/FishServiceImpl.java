package com.brandcrum.aquariums.service;

import com.brandcrum.aquariums.common.builder.FishDTOBuilder;
import com.brandcrum.aquariums.common.builder.TankDTOBuilder;
import com.brandcrum.aquariums.common.dto.FishDTO;
import com.brandcrum.aquariums.model.Fish;
import com.brandcrum.aquariums.model.Tank;
import com.brandcrum.aquariums.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jadiaz on 30/04/18.
 */
@Service
public class FishServiceImpl implements FishService{

    @Autowired
    private FishRepository fishRepository;

    @Override
    public Optional<Long> create(FishDTO fishDTO) {
        return null;
    }

    @Override
    public Optional<FishDTO> findById(Long id) {
        Optional<Fish> fish = fishRepository.findById(id);
        if (fish.isPresent()) {
            return Optional.of(new FishDTOBuilder(fish.get()).build());
        }
        return Optional.empty();
    }

    @Override
    public void update(FishDTO fishDTO) {

    }

    @Override
    public void delete(Long fishId) {

    }
}
