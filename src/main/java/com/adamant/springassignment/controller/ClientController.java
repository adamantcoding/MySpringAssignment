package com.adamant.springassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ivan on 10.9.2017.
 */
@Controller
public class ClientController {

    @GetMapping("/viewOwner")
    public String viewOwner() {
        return "index";
    }

    @GetMapping("/start")
    public String loadStart(){
        return "start";
    }
}