package com.adamant.springassignment.repository;

import com.adamant.springassignment.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Ivan.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByCarOwnerId(Long id);
}