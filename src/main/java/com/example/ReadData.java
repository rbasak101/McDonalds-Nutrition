package com.example;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;

public class ReadData {

    public FoodItem[] readFile(String filePath) {
        try
        {
            //Create a new Gson object
            Gson gson = new Gson();

            //Read the employee.json file
            BufferedReader br = new BufferedReader(
                    new FileReader(filePath));

            //convert the json to  Java object (FoodItem)
            FoodItem[] food = gson.fromJson(br, FoodItem[].class);
            for(int i = 0; i < food.length; i++) {
                // System.out.println(food[i].getCalories().getClass().getSimpleName());
                food[i].printNutrition();

            }
            return food;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new FoodItem[0];
    }
}
