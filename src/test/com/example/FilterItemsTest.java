package test.com.example;
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

import static org.junit.Assert.assertEquals;

public class FilterItemsTest {
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
//            for(int i = 0; i < foodList.size(); i++) {
//                foodList.get(i).printNutrition();
//            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void caloriesRangeTest() {
        FilterItems filter = new FilterItems();
        ArrayList<FoodItem> filtered = filter.getFoodFromCalories(foodList, 0, 0);
        for(int i = 0; i < filtered.size(); i++) {
            filtered.get(i).printNutrition();
        }
    }

    @Test
    public void foodCategoryTest() {
        FilterItems filter = new FilterItems();
        ArrayList<FoodItem> filtered = filter.getFoodFromCategory(foodList,"MCCAFE");
        for(int i = 0; i < filtered.size(); i++) {
            filtered.get(i).printNutrition();
        }
    }

    @Test
    public void proteinMinTest() {
        FilterItems filter = new FilterItems();
        ArrayList<FoodItem> filtered = filter.getFoodFromProtein(foodList, 30);
        for(int i = 0; i < filtered.size(); i++) {
            filtered.get(i).printNutrition();
        }
    }

    @Test
    public void getHealthyTest() {
        FilterItems filter = new FilterItems();
        ArrayList<FoodItem> filtered = filter.getFoodFromProtein(foodList, 30);
        for(int i = 0; i < filtered.size(); i++) {
            filtered.get(i).printNutrition();
        }
    }

}
