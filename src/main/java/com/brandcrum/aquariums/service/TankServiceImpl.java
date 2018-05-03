package com.brandcrum.aquariums.service;

import com.brandcrum.aquariums.common.builder.TankBuilder;
import com.brandcrum.aquariums.common.builder.TankDTOBuilder;
import com.brandcrum.aquariums.common.dto.TankDTO;
import com.brandcrum.aquariums.common.exception.NotFoundException;
import com.brandcrum.aquariums.common.exception.TankCannotBeDeletedException;
import com.brandcrum.aquariums.model.Fish;
import com.brandcrum.aquariums.model.Tank;
import com.brandcrum.aquariums.repository.FishRepository;
import com.brandcrum.aquariums.repository.TankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by jadiaz on 30/04/18.
 */
@Service
public class TankServiceImpl implements TankService {

    private static Logger LOG = LoggerFactory.getLogger(TankServiceImpl.class);

    @Autowired
    private TankRepository tankRepository;

    @Autowired
    private FishRepository fishRepository;

    @Override
    @Transactional
    public Optional<Long> create(TankDTO tankDTO) {
        try {
            Tank tank = tankRepository.save(new TankBuilder(tankDTO).build());
            if (Objects.isNull(tank)) return Optional.empty();
            else return Optional.of(tank.getId());
        } catch (DataAccessException exception) {
            LOG.error("Ha habido una excepción guardando la entidad Tank:: " + exception.getMessage());
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<TankDTO> findById(Long id) {
        Optional<Tank> tank = tankRepository.findById(id);
        if (tank.isPresent()) {
            return Optional.of(new TankDTOBuilder(tank.get(), fishRepository.findAllByTankId(id)).build());
        }
        return Optional.empty();
    }

    @Override
    public void update(TankDTO tankDTO) {

    }

    @Override
    @Transactional
    public void delete(Long tankId) {
        Optional<Tank> tank = tankRepository.findById(tankId);
        tank.orElseThrow(() -> new NotFoundException(String.format("Tank with id %s not found", tankId)));
        List<Fish> fishList = fishRepository.findAllByTankId(tank.get().getId());
        if (!CollectionUtils.isEmpty(fishList)) {
            throw new TankCannotBeDeletedException(String.format("Tank with id %s cannot be removed, it has fish", tankId));
        }
        tankRepository.deleteById(tank.get().getId());
    }
}
