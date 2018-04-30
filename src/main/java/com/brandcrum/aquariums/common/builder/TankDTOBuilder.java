package com.brandcrum.aquariums.common.builder;

import com.brandcrum.aquariums.common.dto.FishDTO;
import com.brandcrum.aquariums.common.dto.TankDTO;
import com.brandcrum.aquariums.model.Fish;
import com.brandcrum.aquariums.model.Tank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jadiaz on 30/04/18.
 */
public class TankDTOBuilder {

    private Tank tank;

    private List<Fish> fishList;

    public TankDTOBuilder(Tank tank, List<Fish> fishList) {
        this.tank = tank;
        this.fishList = fishList;
    }

    public TankDTO build() {
        TankDTO tankDTO = new TankDTO();
        tankDTO.setId(tank.getId());
        tankDTO.setName(tank.getName());
        tankDTO.setTemperature(tank.getTemperature());
        tankDTO.setVolume(tank.getVolume());
        tankDTO.setFishDTOS(fishList.stream().map(fish -> new FishDTOBuilder(fish).build()).collect(Collectors.toList()));
        return tankDTO;
    }
}
