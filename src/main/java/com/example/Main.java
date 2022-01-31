package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.example.Analysis;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.SwingWrapper;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
        String filePath = "/Users/Rbasak101/desktop/McD.json";

        try
        {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            FoodItem[] menu = gson.fromJson(br, FoodItem[].class);
            foodList = new ArrayList<FoodItem>(Arrays.asList(menu));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        FilterItems filter = new FilterItems();
        ArrayList<FoodItem> foodCalorieRange = filter.getFoodFromCalories(foodList, 500, 1000);
        System.out.println("Filtering calories by min and max");
        for (FoodItem i : foodCalorieRange)
        {
            i.printNutrition();
        }
        System.out.println(" ");

        Analysis analyze = new Analysis();
        HashMap<String, List<Integer>> range = analyze.sodiumRangeCategory(foodList);
        System.out.println("Printing sodium range of each category");
        System.out.println(range);
        System.out.println(" ");
        HashMap<String, Integer> freqMap = analyze.getCategoryCount(foodList);

        PieChartMenu pieChart = new PieChartMenu();
        PieChart chart = pieChart.getChartAuto(freqMap);
        chart.setTitle("McDonald's Menu Composition");
        new SwingWrapper<PieChart>(chart).displayChart();
    }
}