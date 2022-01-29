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

}