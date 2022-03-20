package com.mieker.diceRoller.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RollServiceImpl implements RollService {

    Random random = new Random();

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
