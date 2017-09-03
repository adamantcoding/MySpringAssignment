package com.adamant.springassignment.repository;

import com.adamant.springassignment.domain.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivan.
 */
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}