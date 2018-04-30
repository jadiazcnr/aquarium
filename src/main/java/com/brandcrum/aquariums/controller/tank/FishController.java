package com.brandcrum.aquariums.controller.tank;

import com.brandcrum.aquariums.common.dto.FishDTO;
import com.brandcrum.aquariums.common.dto.TankDTO;
import com.brandcrum.aquariums.common.exception.NotFoundException;
import com.brandcrum.aquariums.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jadiaz on 30/04/18.
 */
@RestController
@RequestMapping("/fish")
public class FishController {

    @Autowired
    private FishService fishService;

    @PostMapping
    public ResponseEntity create(@RequestBody CreateTankRequest createTankRequest) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{fishId}")
    public @ResponseBody
    FishDTO findById(@PathVariable Long fishId) throws NotFoundException {
        return fishService.findById(fishId).orElseThrow(() -> new NotFoundException(String.format("Fish=%s not found", fishId)));
    }

    @DeleteMapping("/{tankId}")
    public void remove(@PathVariable Long tankId) {
        fishService.delete(tankId);
    }

}
