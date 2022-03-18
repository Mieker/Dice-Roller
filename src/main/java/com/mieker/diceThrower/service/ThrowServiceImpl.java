package com.mieker.diceThrower.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ThrowServiceImpl implements ThrowService {

    Random random = new Random();

    @Override
    public int multipleThrows(int numberOfD4, int numberOfD6, int numberOfD8, int numberOfD10, int numberOfD12, int numberOfD20, int modification) {
        int result = 0;
        result += numberOfD4 * throwDice(4);
        result += numberOfD6 * throwDice(6);
        result += numberOfD8 * throwDice(8);
        result += numberOfD10 * throwDice(10);
        result += numberOfD12 * throwDice(12);
        result += numberOfD20 * throwDice(20);
        result += modification;
        return result;
    }

    private int throwDice(int value) {
        return random.nextInt(value) + 1;
    }

}
