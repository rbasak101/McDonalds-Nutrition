package test.com.example;
import com.example.FoodItem;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

//It may be a good idea to rename/refactor depending on the focus of your assignment.
public class FoodItemTest {
    private Gson gson;
    private String filePath = "/Users/Rbasak101/desktop/McD.json";
    @Before
    public void setUp() {
        // This is run before every test.
        gson = new Gson();
    }

    @Test
    public void createOneFoodItem() {
        String json = "{\"CAL\":\"740\",\"FAT\":\"41\",\"SFAT\":\"16\",\"TFAT\":\"1.5\",\"CHOL\":\"125\",\"SALT\":\"1480\",\"CARB\":\"51\",\"FBR\":\"4\",\"SGR\":\"14\",\"PRO\":\"40\",\"ITEM\":\"Bacon Clubhouse Burger 9.7 oz (274 g)\",\"CATEGORY\":\"BURGERSANDWICH\"}";
        FoodItem food = gson.fromJson(json, FoodItem.class);
        food.printNutrition();
        assertEquals("Bacon Clubhouse Burger 9.7 oz (274 g)", food.getName());
        assertEquals("740", food.getCalories());
        assertEquals("41", food.getFat());
        assertEquals("40", food.getProtein());
        assertEquals("14", food.getSugar());
        assertEquals("1480", food.getSalt());
    }

    @Test
    public void readJsonToFoodItem() {
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
            // Check to see if objects are equal as well
            assertEquals(471, food.length); // number of objects
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}