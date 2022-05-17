package com.mieker.diceRoller.controller;

import com.mieker.diceRoller.model.DataDto;
import com.mieker.diceRoller.model.ThrowResult;
import com.mieker.diceRoller.service.RollService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://dicethrowerapp-front.herokuapp.com/", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
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

    @GetMapping("/d4")
    public ResponseEntity<?> d4Throw() {
        int myThrow = rollService.multipleRolls(1, 0, 0, 0, 0, 0, 0);
        Map throwObj = new HashMap();
        throwObj.put("throw", myThrow);
        return new ResponseEntity<>(throwObj, HttpStatus.OK);
    }

    @GetMapping("/d6")
    public ResponseEntity<?> d6Throw() {
        int myThrow = rollService.multipleRolls(0, 1, 0, 0, 0, 0, 0);
        Map throwObj = new HashMap();
        throwObj.put("throw", myThrow);
        return new ResponseEntity<>(throwObj, HttpStatus.OK);
    }

    @GetMapping("/d8")
    public ResponseEntity<?> d8Throw() {
        int myThrow = rollService.multipleRolls(0, 0, 1, 0, 0, 0, 0);
        Map throwObj = new HashMap();
        throwObj.put("throw", myThrow);
        return new ResponseEntity<>(throwObj, HttpStatus.OK);
    }

    @GetMapping("/d10")
    public ResponseEntity<?> d10Throw() {
        int myThrow = rollService.multipleRolls(0, 0, 0, 1, 0, 0, 0);
        Map throwObj = new HashMap();
        throwObj.put("throw", myThrow);
        return new ResponseEntity<>(throwObj, HttpStatus.OK);
    }

    @GetMapping("/d12")
    public ResponseEntity<?> d12Throw() {
        int myThrow = rollService.multipleRolls(0, 0, 0, 0, 1, 0, 0);
        Map throwObj = new HashMap();
        throwObj.put("throw", myThrow);
        return new ResponseEntity<>(throwObj, HttpStatus.OK);
    }

    @GetMapping("/d20")
    public ResponseEntity<?> d20Throw() {
        int myThrow = rollService.multipleRolls(0, 0, 0, 0, 0, 1, 0);
        Map throwObj = new HashMap();
        throwObj.put("throw", myThrow);
        return new ResponseEntity<>(throwObj, HttpStatus.OK);
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
