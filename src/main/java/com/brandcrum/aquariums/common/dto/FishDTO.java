package com.brandcrum.aquariums.common.dto;

import com.brandcrum.aquariums.common.types.FishType;

import java.math.BigDecimal;

public class FishDTO {

    private Long id;

    private String name;

    private FishType type;

    private BigDecimal price;

    private Long tank;

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

    public FishType getType() {
        return type;
    }

    public void setType(FishType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getTank() {
        return tank;
    }

    public void setTank(Long tank) {
        this.tank = tank;
    }
}
