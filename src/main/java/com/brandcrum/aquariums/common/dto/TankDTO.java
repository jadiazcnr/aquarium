package com.brandcrum.aquariums.common.dto;

import java.util.List;

public class TankDTO {

    private Long id;

    private String name;

    private Double volume;

    private Double temperature;

    private List<FishDTO> fishDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public List<FishDTO> getFishDTOS() {
        return fishDTOS;
    }

    public void setFishDTOS(List<FishDTO> fishDTOS) {
        this.fishDTOS = fishDTOS;
    }
}
