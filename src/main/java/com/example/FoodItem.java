package com.example;
import com.google.gson.Gson;
import java.io.*;

public class FoodItem {
    private String CAL; //
    private String FAT; //
    private String SFAT;
    private String TFAT;
    private String CHOL;
    private String SALT; //
    private String CARB;
    private String FBR;
    private String SGR; //
    private String PRO; //
    private String ITEM; //
    private String CATEGORY; //

    public FoodItem() {

    }

    public String getCalories() {
        return this.CAL;
    }

    public String getFat() {
        return this.FAT;
    }

    public String getSalt() {
        return SALT;
    }

    public String getSugar() {
        return SGR;
    }

    public String getProtein() {
        return PRO;
    }

    public String getName() {
        return this.ITEM;
    }

    public String getCategory() {
        return this.CATEGORY;
    }

    public void printNutrition() {
        System.out.println("Name: " + this.getName());
        System.out.println("Category: " + this.getCategory());
        System.out.println("Calories: " + this.getCalories());
        System.out.println("Fat: " + this.getFat());
        System.out.println("Protein: " + this.getProtein());
        System.out.println("Sugar: " + this.getSugar());
        System.out.println("Salt: " + this.getSalt());
        System.out.println(" ");
    }

    public static void main(String[] args) {
//        String json = "{\"CAL\":\"740\",\"FAT\":\"41\",\"SFAT\":\"16\",\"TFAT\":\"1.5\",\"CHOL\":\"125\",\"SALT\":\"1480\",\"CARB\":\"51\",\"FBR\":\"4\",\"SGR\":\"14\",\"PRO\":\"40\",\"ITEM\":\"Bacon Clubhouse Burger 9.7 oz (274 g)\",\"CATEGORY\":\"BURGERSANDWICH\"}";
//        Gson gson = new Gson();
//        FoodItem food = gson.fromJson(json, FoodItem.class);
//        food.printNutrition();

        String filePath = "/Users/Rbasak101/desktop/McD.json";
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
            System.out.println(food.length); // 471 as expected
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}