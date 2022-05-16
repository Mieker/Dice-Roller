package com.mieker.diceRoller.controller;

import com.mieker.diceRoller.model.DataDto;
import com.mieker.diceRoller.service.RollService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;


@RestController
@CrossOrigin(origins = "https://dicethrowerapp-front.herokuapp.com/roll/d6/")
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

    @GetMapping("/d6")
    public JSONObject d6Throw() {
        int myThrow = rollService.multipleRolls(0, 1, 0, 0, 0, 0, 0);

        JSONObject job = new JSONObject();
        job.put("throw", myThrow);

        return job;
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
