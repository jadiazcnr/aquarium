package com.brandcrum.aquariums.service;

import com.brandcrum.aquariums.common.dto.FishDTO;

import java.util.Optional;

/**
 * Created by jadiaz on 30/04/18.
 */
public interface FishService {

    Optional<Long> create(FishDTO fishDTO);

    Optional<FishDTO> findById(Long id);

    void update(FishDTO fishDTO);

    void delete(Long fishId);
}
