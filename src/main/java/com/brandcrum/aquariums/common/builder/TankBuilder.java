package com.brandcrum.aquariums.common.builder;

import com.brandcrum.aquariums.common.dto.TankDTO;
import com.brandcrum.aquariums.model.Fish;
import com.brandcrum.aquariums.model.Tank;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jadiaz on 30/04/18.
 */
public class TankBuilder {

    private TankDTO tankDTO;

    public TankBuilder(TankDTO tankDTO) {
        this.tankDTO = tankDTO;
    }

    public Tank build() {
        Tank tank = new Tank();
        tank.setId(tankDTO.getId());
        tank.setName(tankDTO.getName());
        tank.setTemperature(tankDTO.getTemperature());
        tank.setVolume(tankDTO.getVolume());
        return tank;
    }
}
