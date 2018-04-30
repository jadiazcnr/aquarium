package com.brandcrum.aquariums.repository;

import com.brandcrum.aquariums.model.Fish;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jadiaz on 30/04/18.
 */
@Repository
public interface FishRepository extends PagingAndSortingRepository<Fish, Long>{

    List<Fish> findAllByTankId(@Param("tankId") Long tankId);
}
