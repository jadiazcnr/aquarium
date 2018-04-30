package com.brandcrum.aquariums.service;

import com.brandcrum.aquariums.common.dto.FishDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jadiaz on 30/04/18.
 */
@Service
public class FishServiceImpl implements FishService{

    @Override
    public Optional<Long> create(FishDTO fishDTO) {
        return null;
    }

    @Override
    public Optional<FishDTO> findById(Long id) {
        return null;
    }

    @Override
    public void update(FishDTO fishDTO) {

    }

    @Override
    public void delete(Long fishId) {

    }
}
