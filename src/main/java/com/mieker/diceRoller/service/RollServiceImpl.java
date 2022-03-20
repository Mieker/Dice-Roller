package com.mieker.diceRoller.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RollServiceImpl implements RollService {

    Random random = new Random();

    @Override
    public String printResult(int numberOfD4, int numberOfD6, int numberOfD8, int numberOfD10, int numberOfD12, int numberOfD20, int modification) {
        int minResult = 0;
        minResult = numberOfD4 + numberOfD6 + numberOfD8 + numberOfD10 + numberOfD12 + numberOfD20 + modification;
        int maxResult = 0;
        maxResult = numberOfD4 * 4 + numberOfD6 * 6 + numberOfD8 * 8 + numberOfD10 * 10 + numberOfD12 * 12 + numberOfD20 * 20 + modification;


        String finalResult = "Rolling:    ";
        if (numberOfD20 > 0) finalResult += numberOfD20 + "d20";
        if (numberOfD12 > 0) finalResult += " + " + numberOfD12 + "d12";
        if (numberOfD10 > 0) finalResult += " + " + numberOfD10 + "d10";
        if (numberOfD8 > 0) finalResult += " + " + numberOfD8 + "d8";
        if (numberOfD6 > 0) finalResult += " + " + numberOfD6 + "d6";
        if (numberOfD4 > 0) finalResult += " + " + numberOfD4 + "d4";
        if (modification > 0) finalResult += " + " + modification;
        finalResult += "\nMin - Max:  " + minResult + " - " + maxResult;
        finalResult += "\nResult:     ";
        finalResult += multipleRolls(numberOfD4, numberOfD6, numberOfD8, numberOfD10, numberOfD12, numberOfD20, modification);
        if (finalResult.charAt(13) == '+') {
            finalResult = finalResult.substring(0, 11) + finalResult.substring(14);
        }
        return finalResult;
    }

    @Override
    public int multipleRolls(int numberOfD4, int numberOfD6, int numberOfD8, int numberOfD10, int numberOfD12, int numberOfD20, int modification) {
        int result = 0;
        result += numberOfD4 * rollDice(4);
        result += numberOfD6 * rollDice(6);
        result += numberOfD8 * rollDice(8);
        result += numberOfD10 * rollDice(10);
        result += numberOfD12 * rollDice(12);
        result += numberOfD20 * rollDice(20);
        result += modification;
        return result;
    }

    private int rollDice(int value) {
        return random.nextInt(value) + 1;
    }

}
