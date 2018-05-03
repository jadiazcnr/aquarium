package com.brandcrum.aquariums.controller.tank;


import com.brandcrum.aquariums.common.dto.TankDTO;
import com.brandcrum.aquariums.common.exception.NotFoundException;
import com.brandcrum.aquariums.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/tank")
public class TankController {

    @Autowired
    private TankService tankService;

    @PostMapping
    public ResponseEntity create(@RequestBody TankDTO tankDTO) {
        tankService.create(tankDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{tankId}")
    public @ResponseBody TankDTO findById(@PathVariable Long tankId) throws NotFoundException {
        return tankService.findById(tankId).orElseThrow(() -> new NotFoundException(String.format("Tank=%s not found", tankId)));
    }

    @DeleteMapping("/{tankId}")
    public void remove(@PathVariable Long tankId) {
        tankService.delete(tankId);
    }

    @ExceptionHandler(NotFoundException.class)
    void handleIllegalArgumentException(NotFoundException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
