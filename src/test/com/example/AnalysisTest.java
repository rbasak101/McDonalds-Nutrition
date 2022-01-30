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

import static org.junit.Assert.assertEquals;

public class AnalysisTest {
    private String filePath = "/Users/Rbasak101/desktop/McD.json";
    private String filePathTest = "/Users/Rbasak101/desktop/McDTest.json";
    public ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();

    @Before
    public void initialize() {
        try
        {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(filePathTest));

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
        HashMap<String, Integer> freqMap = analyze.getCategoryCount(foodList);
        System.out.println(freqMap);
        int total = 0;
        for (Integer iterator: freqMap.values()) {
            total += iterator.intValue();
        }
        assertEquals(18, total);
        assertEquals(2, freqMap.get("SALAD").intValue());
        assertEquals(2, freqMap.get("BEVERAGE").intValue());
        assertEquals(3, freqMap.get("BURGERSANDWICH").intValue());
        assertEquals(2, freqMap.get("BREAKFAST").intValue());
        assertEquals(1, freqMap.get("MCCAFE").intValue());
        assertEquals(2, freqMap.get("SNACKSIDE").intValue());
        assertEquals(1, freqMap.get("CONDIMENT").intValue());
        assertEquals(1, freqMap.get("ALLDAYBREAKFAST").intValue());
        assertEquals(1, freqMap.get("DESSERTSHAKE").intValue());
        assertEquals(3, freqMap.get("CHICKENFISH").intValue());

        HashMap<String, Double> percentageMap = analyze.getCategoryPercentage(foodList);
        System.out.println(percentageMap);
        double totalPercent = 0.0;
        for (Double iterator: percentageMap.values()) {
            totalPercent += iterator.doubleValue();
        }
        assertEquals(100, (int)totalPercent);

    }

    @Test
    public void getAverageCalories() {
        Analysis analyze = new Analysis();
        double average = analyze.getAverageCalories(foodList);
        System.out.println("Average Calories: " + average);
        assertEquals(398.8888888888889, average, .0001);
    }

    @Test
    public void sortCalories() { // Descending Calories
        Analysis analyze = new Analysis();
        ArrayList<FoodItem> sorted = analyze.sortCalories(foodList);
        for(int i = 0; i < sorted.size(); i++) {
            sorted.get(i).printNutrition();
        }
        assertEquals("Premium Buttermilk Crispy Chicken Bacon Clubhouse Sandwich 10.1 oz (287 g)",
                sorted.get(0).getName());
    }

    @Test
    public void sodiumRange() {
        Analysis analyze = new Analysis();
        HashMap<String, List<Integer>> range = analyze.sodiumRangeCategory(foodList);
        System.out.println(range);

        assertEquals(530, range.get("SALAD").get(0).intValue());
        assertEquals(1120, range.get("SALAD").get(1).intValue());

        assertEquals(65, range.get("BEVERAGE").get(0).intValue());
        assertEquals(125, range.get("BEVERAGE").get(1).intValue());

        assertEquals(650, range.get("BURGERSANDWICH").get(0).intValue());
        assertEquals(1620, range.get("BURGERSANDWICH").get(1).intValue());

        assertEquals(830, range.get("BREAKFAST").get(0).intValue());
        assertEquals(1420, range.get("BREAKFAST").get(1).intValue());

        assertEquals(125, range.get("MCCAFE").get(0).intValue());
        assertEquals(125, range.get("MCCAFE").get(1).intValue());

        assertEquals(190, range.get("SNACKSIDE").get(0).intValue());
        assertEquals(290, range.get("SNACKSIDE").get(1).intValue());

        assertEquals(115, range.get("CONDIMENT").get(0).intValue());
        assertEquals(115, range.get("CONDIMENT").get(1).intValue());

        assertEquals(790, range.get("ALLDAYBREAKFAST").get(0).intValue());
        assertEquals(790, range.get("ALLDAYBREAKFAST").get(1).intValue());

        assertEquals(160, range.get("DESSERTSHAKE").get(0).intValue());
        assertEquals(160, range.get("DESSERTSHAKE").get(1).intValue());

        assertEquals(800, range.get("CHICKENFISH").get(0).intValue());
        assertEquals(1250, range.get("CHICKENFISH").get(1).intValue());

    }

}
