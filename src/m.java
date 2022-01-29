import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;
public class Main {

    @Before
    public void initialize() {
        Gson gson = new Gson();
        FoodItem = gson.fromJson("https://github.com/tsterbak/data-mcdonalds-nutritionfacts/blob/master/json/mcd-pretty.json", FoodItem.class);
    }
    public static void main(String[] args) {
        System.out.print("Hello")
    }
}