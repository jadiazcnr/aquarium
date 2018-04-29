package com.brandcrum.aquariums.controller.tank;

import com.brandcrum.aquariums.common.dto.TankDTO;

public class CreateTankRequest {

    private TankDTO tankDTO;

    public TankDTO getTankDTO() {
        return tankDTO;
    }

    public void setTankDTO(TankDTO tankDTO) {
        this.tankDTO = tankDTO;
    }
}
