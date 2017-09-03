package com.adamant.springassignment.service;

import com.adamant.springassignment.domain.Car;
import com.adamant.springassignment.domain.CarModel;
import com.adamant.springassignment.domain.CarOwner;
import com.adamant.springassignment.repository.CarModelRepository;
import com.adamant.springassignment.repository.CarOwnerRepository;
import com.adamant.springassignment.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ivan.
 */
@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    CarModelRepository carModelRepository;
    @Autowired
    CarOwnerRepository carOwnerRepository;

    public CarModel createCarModel(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    public CarOwner createOwner(CarOwner carOwner) {
       return carOwnerRepository.save(carOwner);
    }

    public CarOwner getOwner(Long id) {
        return carOwnerRepository.findOne(id);
    }

    public List<Car> findCarsByOwner(Long id){
        return carRepository.findAllByCarOwnerId(id);
    }

    public Collection<Car> addCarToOwner(Long id, Car car) {
        car.setCarOwner(carOwnerRepository.findCarOwnerById(id));
        carRepository.save(car);
        return findCarsByOwner(id);
    }

    public Collection<Car> findAllCars() {
        return carRepository.findAll();
    }
}