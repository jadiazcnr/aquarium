package com.brandcrum.aquariums.service;

import com.brandcrum.aquariums.common.dto.TankDTO;

import java.util.Optional;

public interface TankService {

    Optional<Long> createTank(TankDTO tankDTO);
}
