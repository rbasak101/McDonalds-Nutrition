package test.com.example;
import com.example.FoodItem;
import com.example.ReadData;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//It may be a good idea to rename/refactor depending on the focus of your assignment.
public class FoodItemTest {
    private Gson gson;

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
        assertEquals(740.0, food.getCalories(), .00);
        assertEquals(41.0, food.getFat(), .00);
        assertEquals(40.0, food.getProtein(), .00);
        assertEquals(14, food.getSugar(), .00);
        assertEquals(1480, food.getSalt(), .00);
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
        assertEquals(400,food1.compareTo(food2));
    }
}