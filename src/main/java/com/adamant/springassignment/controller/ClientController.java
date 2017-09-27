package com.adamant.springassignment.controller;

import com.adamant.springassignment.domain.Car;
import com.adamant.springassignment.domain.CarOwner;
import com.adamant.springassignment.repository.CarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ivan on 10.9.2017.
 */
@Controller
public class ClientController {

    @Autowired
    CarOwnerRepository carOwnerRepository;
    @GetMapping("/start")
    public String viewOwner() {
        return "start";
    }

    @GetMapping ("/owner/{id}/cars")
    public String getCars(@PathVariable Long id, Model model){
        model.addAttribute("cars", carOwnerRepository.findCarOwnerById(id));
        return "cars";
    }

//    @GetMapping ("/owner/{id}/cars")
//    public String result(@PathVariable Long id, Model model){
//        model.addAttribute("cars", carOwnerRepository.findCarOwnerById(id));
//        return "start";
//    }

    @GetMapping ("/cars")
    public String getAllCars(Model model){
        model.addAttribute("cars", carOwnerRepository.findAll());
        return "cars";
    }
}