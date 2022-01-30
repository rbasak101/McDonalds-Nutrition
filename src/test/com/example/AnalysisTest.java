package test.com.example;

import com.example.Analysis;
import com.example.FilterItems;
import com.example.FoodItem;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnalysisTest {
    private String filePath = "/Users/Rbasak101/desktop/McD.json";
    public ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();

    @Before
    public void initialize() {
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
    }

    @Test
    public void categoryPercentageTest() {
        Analysis analyze = new Analysis();
        HashMap<String, Integer> map = analyze.getCategoryCount(foodList);
        System.out.println(map);

        HashMap<String, Double> map2 = analyze.getCategoryPercentage(foodList);
        System.out.println(map2);

    }

    @Test
    public void getAverageCalories() {
        Analysis analyze = new Analysis();
        double average = analyze.getAverageCalories(foodList);
        System.out.println("Average Calories: " + average);
    }

    @Test
    public void sortCalories() {
        Analysis analyze = new Analysis();
        ArrayList<FoodItem> sorted = analyze.sortCalories(foodList);
        for(int i = 0; i < sorted.size(); i++) {
            sorted.get(i).printNutrition();
        }
    }

    @Test
    public void sodiumRange() {
        Analysis analyze = new Analysis();
        HashMap<String, List<Integer>> range = analyze.sodiumRangeCategory(foodList);
        System.out.println(range);
    }


}
