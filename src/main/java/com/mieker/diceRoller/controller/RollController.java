package com.mieker.diceRoller.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mieker.diceRoller.model.DataDto;
import com.mieker.diceRoller.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;


@RestController
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RequestMapping("/roll")
public class RollController {

    @Autowired
    private final RollService rollService;

    public RollController(RollService rollService) {
        this.rollService = rollService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello traveler";
    }

//    @GetMapping
//    //parameters assume the number of dice rolls
//    public int multipleRolls(@RequestParam int d4, @RequestParam int d6, @RequestParam int d8, @RequestParam int d10,
//                             @RequestParam int d12, @RequestParam int d20, @RequestParam int modification) {
//        return rollService.multipleRolls(d4, d6, d8, d10, d12, d20, modification);
//    }

    @GetMapping
    public String multipleRolls(@RequestParam int d4, @RequestParam int d6, @RequestParam int d8, @RequestParam int d10,
                                @RequestParam int d12, @RequestParam int d20, @RequestParam int modification) {
        return rollService.printResult(d4, d6, d8, d10, d12, d20, modification);
    }

    @GetMapping("/history")
    public DataDto showHistory() {
        DataDto dataToShow = new DataDto();
        try {
            dataToShow.loadData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataToShow;
    }
}