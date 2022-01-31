package test.com.example;
import com.example.FoodItem;
import com.example.ReadData;
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
    private String filePathTest = "/Users/Rbasak101/desktop/McDTest.json";

    @Before
    public void setUp() {
        gson = new Gson();
    }

    @Test
    public void createOneFoodItem() {
        String json = "{\"CAL\":\"740\",\"FAT\":\"41\",\"SFAT\":\"16\",\"TFAT\":\"1.5\"," +
                "\"CHOL\":\"125\",\"SALT\":\"1480\",\"CARB\":\"51\",\"FBR\":\"4\",\"SGR\":" +
                "\"14\",\"PRO\":\"40\",\"ITEM\":\"Bacon Clubhouse Burger 9.7 oz (274 g)\",\"CATEGORY\":" +
                "\"BURGERSANDWICH\"}";
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
    public void compareToTest() {
        String json = "{\"CAL\":\"740\",\"FAT\":\"41\",\"SFAT\":\"16\",\"TFAT\":\"1.5\"," +
                "\"CHOL\":\"125\",\"SALT\":\"1480\",\"CARB\":\"51\",\"FBR\":\"4\",\"SGR\":" +
                "\"14\",\"PRO\":\"40\",\"ITEM\":\"Bacon Clubhouse Burger 9.7 oz (274 g)\",\"CATEGORY\":" +
                "\"BURGERSANDWICH\"}";
        FoodItem food1 = gson.fromJson(json, FoodItem.class);
        String json2 = "{\"CAL\":\"340\",\"FAT\":\"11\",\"SFAT\":\"7\",\"TFAT\":\"0\"," +
                "\"CHOL\":\"35\",\"SALT\":\"150\",\"CARB\":\"49\",\"FBR\":\"2\",\"SGR\":" +
                "\"42\",\"PRO\":\"10\",\"ITEM\":\"McCafe Mocha (Small) 12 fl oz cup\",\"CATEGORY\":" +
                "\"MCCAFE\"}";
        FoodItem food2 = gson.fromJson(json2, FoodItem.class);
        //assertEquals(400,food1.compareTo(food2));

    }

    @Test
    public void readJsonToFoodItem() {
        ReadData deserialize = new ReadData();
        FoodItem[] food = deserialize.readFile(filePathTest);
        for(int i = 0; i < food.length; i++) {
            food[i].printNutrition();

        }
        assertEquals(18, food.length); // number of objects
        String firstItemName = food[0].getName();
        String lastItemName = food[food.length-1].getName();
        assertEquals("Bacon Clubhouse Burger 9.7 oz (274 g)", firstItemName);
        assertEquals("Sausage Burrito 3.9 oz (111 g)", lastItemName);

    }
}