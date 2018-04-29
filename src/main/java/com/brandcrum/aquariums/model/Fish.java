package com.brandcrum.aquariums.model;

import com.brandcrum.aquariums.common.FishType;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class Fish {

    private Long id;

    private String name;

    private FishType fishType;

    private BigDecimal price;

    @ManyToOne
    private Tank tank;

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

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
