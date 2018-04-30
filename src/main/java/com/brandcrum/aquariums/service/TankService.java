package com.brandcrum.aquariums.service;

import com.brandcrum.aquariums.common.dto.TankDTO;

import java.util.Optional;

public interface TankService {

    Optional<Long> create(TankDTO tankDTO);

    Optional<TankDTO> findById(Long id);

    void update(TankDTO tankDTO);

    void delete(Long tankId);
}
