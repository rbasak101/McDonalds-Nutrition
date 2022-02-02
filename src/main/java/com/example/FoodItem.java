package com.example;
import java.io.*;

public class FoodItem implements Comparable<FoodItem>{
    private double CAL;
    private double FAT;
    private double SALT;
    private double SGR;
    private double PRO;
    private String ITEM;
    private String CATEGORY;

    public double getCalories() {
        return this.CAL;
    }

    public double getFat() {
        return this.FAT;
    }

    public double getSalt() {
        return SALT;
    }

    public double getSugar() {
        return SGR;
    }

    public double getProtein() {
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

    @Override
    public int compareTo(FoodItem other) {
        int calorieOther = (int) other.getCalories();
        int current = (int)(this.CAL);
        return current - calorieOther; //ascending order
        //return calorieOther - current; //descending order
    }

}