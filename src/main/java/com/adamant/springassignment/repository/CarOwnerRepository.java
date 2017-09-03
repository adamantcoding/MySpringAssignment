package com.adamant.springassignment.repository;

import com.adamant.springassignment.domain.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivan.
 */
public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
    CarOwner findCarOwnerById(Long id);
}