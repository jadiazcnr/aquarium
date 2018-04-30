package com.brandcrum.aquariums.common.dto;

import com.brandcrum.aquariums.common.types.FishType;

import java.math.BigDecimal;

public class FishDTO {

    private Long id;

    private String name;

    private FishType fishType;

    private BigDecimal price;

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

    public FishType getFishType() {
        return fishType;
    }

    public void setFishType(FishType fishType) {
        this.fishType = fishType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
