package test.com.example;
import com.example.FilterItems;
import com.example.FoodItem;
import com.example.ReadData;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FilterItemsTest {
    private String filePathTest = "/Users/Rbasak101/desktop/McDTest.json";
    private ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();

    @Before
    public void initialize() {
        ReadData deserialize = new ReadData();
        FoodItem[] menu = deserialize.readFile(filePathTest);
        foodList = new ArrayList<FoodItem>(Arrays.asList(menu));
    }

    @Test
    public void caloriesRangeTest() {
        FilterItems filter = new FilterItems();
        ArrayList<FoodItem> filtered = filter.getFoodFromCalories(foodList, 510, 740);
        for(int i = 0; i < filtered.size(); i++) {
            filtered.get(i).printNutrition();
        }
        assertEquals(3, filtered.size());
        assertEquals("Bacon Clubhouse Burger 9.7 oz (274 g)", filtered.get(0).getName());
        assertEquals("Steak & Egg Biscuit (Regular Biscuit) 7 oz (198 g)", filtered.get(1).getName());
        assertEquals("Large French Fries 5.9 oz (168 g)", filtered.get(2).getName());
    }

    @Test
    public void foodCategoryTest() {
        FilterItems filter = new FilterItems();
        ArrayList<FoodItem> filtered = filter.getFoodFromCategory(foodList,"BEVERAGE");
        for(int i = 0; i < filtered.size(); i++) {
            filtered.get(i).printNutrition();
        }
        assertEquals(2, filtered.size());
        assertEquals("Frappe Caramel (Small) 12 fl oz cup", filtered.get(0).getName());
        assertEquals("Iced Coffee Caramel (Large) -", filtered.get(1).getName());
    }

    @Test
    public void proteinMinTest() {
        FilterItems filter = new FilterItems();
        ArrayList<FoodItem> filtered = filter.getFoodFromProtein(foodList, 35);
        for(int i = 0; i < filtered.size(); i++) {
            filtered.get(i).printNutrition();
        }
        assertEquals(3, filtered.size());
        assertEquals("Bacon Clubhouse Burger 9.7 oz (274 g)", filtered.get(0).getName());
        assertEquals("Premium Buttermilk Crispy Chicken Bacon Clubhouse Sandwich 10.1 oz (287 g)", filtered.get(1).getName());
        assertEquals("Premium Bacon Ranch Salad with Grilled Chicken 9.4 oz (266 g)", filtered.get(2).getName());
    }

    @Test
    public void getHealthyTest() {
        FilterItems filter = new FilterItems();
        ArrayList<FoodItem> filtered = filter.getHealthyFood(foodList);
        for(int i = 0; i < filtered.size(); i++) {
            filtered.get(i).printNutrition();
        }
        assertEquals(6, filtered.size());
        assertEquals("Premium Buttermilk Crispy Chicken Bacon Clubhouse Sandwich 10.1 oz (287 g)", filtered.get(0).getName());
        assertEquals("Southern Style Buttermilk Crispy Chicken Sandwich 5.7 oz (162 g)", filtered.get(1).getName());
        assertEquals("Premium McWrap Chicken Sweet Chili (Grilled) 10.4 oz (294 g)", filtered.get(2).getName());
        assertEquals("Ranch Snack Wrap® (Grilled) 4.5 oz (128 g)", filtered.get(3).getName());
        assertEquals("Premium Bacon Ranch Salad (without chicken) 5.9 oz (169 g)", filtered.get(4).getName());
        assertEquals("Premium Bacon Ranch Salad with Grilled Chicken 9.4 oz (266 g)", filtered.get(5).getName());
    }
}
