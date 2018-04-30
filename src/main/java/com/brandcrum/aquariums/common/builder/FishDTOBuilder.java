package com.brandcrum.aquariums.common.builder;

import com.brandcrum.aquariums.common.dto.FishDTO;
import com.brandcrum.aquariums.common.dto.TankDTO;
import com.brandcrum.aquariums.model.Fish;
import com.brandcrum.aquariums.model.Tank;

/**
 * Created by jadiaz on 30/04/18.
 */
public class FishDTOBuilder {

    private Fish fish;

    public FishDTOBuilder(Fish fish) {
        this.fish = fish;
    }

    public FishDTO build() {
        FishDTO fishDTO = new FishDTO();
        fishDTO.setId(fish.getId());
        fishDTO.setName(fish.getName());
        fishDTO.setFishType(fish.getFishType());
        fishDTO.setPrice(fish.getPrice());
        return fishDTO;
    }
}
