package com.brandcrum.aquariums.common.builder;

import com.brandcrum.aquariums.common.dto.FishDTO;
import com.brandcrum.aquariums.model.Fish;

/**
 * Created by jadiaz on 30/04/18.
 */
public class FishBuilder {

    private FishDTO fishDTO;

    public FishBuilder(FishDTO fishDTO) {
        this.fishDTO = fishDTO;
    }

    public Fish build() {
        Fish fish = new Fish();
        fish.setId(fishDTO.getId());
        fish.setName(fishDTO.getName());
        fish.setFishType(fishDTO.getType());
        fish.setPrice(fishDTO.getPrice());
        return fish;
    }
}
