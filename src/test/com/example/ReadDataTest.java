package test.com.example;

import com.example.FoodItem;
import com.example.ReadData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadDataTest {
    private String filePathTest = "/Users/Rbasak101/desktop/McDTest.json";

    @Test
    public void readInvalid() throws Exception {
        ReadData deserialize = new ReadData();
        FoodItem[] food = deserialize.readFile("");
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
