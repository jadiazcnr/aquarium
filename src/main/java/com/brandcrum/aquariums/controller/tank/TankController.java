package com.brandcrum.aquariums.controller.tank;


import com.brandcrum.aquariums.common.exception.TankNotCreatedException;
import com.brandcrum.aquariums.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tank")
public class TankController {

    @Autowired
    private TankService tankService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody CreateTankRequest createTankRequest) {
        return tankService.createTank(createTankRequest.getTankDTO()).orElseThrow(() -> new TankNotCreatedException());
    }
}
