package com.brandcrum.aquariums.repository;

import com.brandcrum.aquariums.model.Tank;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jadiaz on 30/04/18.
 */
@Repository
public interface TankRepository extends PagingAndSortingRepository<Tank, Long> {
}
