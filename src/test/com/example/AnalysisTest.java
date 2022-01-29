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
}
