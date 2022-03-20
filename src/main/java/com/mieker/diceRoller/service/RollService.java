package com.mieker.diceRoller.service;

public interface RollService {

    public String printResult(int numberOfD4, int numberOfD6, int numberOfD8, int numberOfD10, int numberOfD12, int numberOfD20, int modification);

    public int multipleRolls(int numberOfD4, int numberOfD6, int numberOfD8, int numberOfD10, int numberOfD12, int numberOfD20, int modification);
}
