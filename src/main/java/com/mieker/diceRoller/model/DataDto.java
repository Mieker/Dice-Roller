package com.mieker.diceRoller.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@JsonAutoDetect
public class DataDto {

    private ArrayList<String> rollDataArray = new ArrayList<String>();

    public void setRollDataArray(ArrayList<String> rollDataArray) {
        this.rollDataArray = rollDataArray;
    }

    public ArrayList<String> getRollDataArray() {
        return rollDataArray;
    }

    public void loadData() throws FileNotFoundException {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("rolldata.txt"));
            String record = reader.readLine();
            while (record != null) {
                this.rollDataArray.add(record);
                record = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
