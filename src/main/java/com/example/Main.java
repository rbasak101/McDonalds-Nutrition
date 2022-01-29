package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/Rbasak101/desktop/McD.json";
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
                food[i].printNutrition();
            }
            System.out.println(food.length); // 471 as expected
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}