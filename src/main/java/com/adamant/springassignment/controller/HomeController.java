package com.adamant.springassignment.controller;

import com.adamant.springassignment.domain.*;
import com.adamant.springassignment.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

/**
 * The HomeController class is supposed to handle the basic functionality:
 * 1. create a car model
 * 2. create a car owner
 * 3. create a car and add it to the owner
 * 4. extract all the cars
 * 5. extract the cars by owner
 * 6. fetch all the owners
 *
 * I intentionally omitted the createCar method since it was decided from the start to immediately assign a certain owner to the car,
 * and this is handled by the appropriate method.
 * Different behavior (a car without an owner) might be implemented as well. Any suggestions are welcome.
 */
@RestController
public class HomeController {
    @Autowired
    CarService carService;

    @PostMapping(value = "/carModel/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CarModel createModel(@RequestBody CarModel carModel){
        return carService.createCarModel(carModel);
    }

    @PostMapping("/carOwner/addCar/{id}")
    public Collection<Car> addCar(@RequestBody Car car, @PathVariable("id") Long id){
        return carService.addCarToOwner(id, car);
    }

    @PostMapping("/carOwner/create")
    public CarOwner createOwner(@RequestBody CarOwner carOwner){
        return carService.createOwner(carOwner);
    }

    @GetMapping("/carOwner/{id}")
    public CarOwner getOwner(@PathVariable("id") Long id){
        return carService.getOwner(id);
    }

    @GetMapping("/cars/carOwner/{id}")
    public Collection<Car> getAllCarsByOwner(@PathVariable("id") Long id){
        return carService.findCarsByOwner(id);
    }

    @GetMapping("/cars/all")
    public Collection<Car> getAllCars(){
        return carService.findAllCars();
    }
}