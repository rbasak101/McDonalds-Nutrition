package com.example;
import java.util.ArrayList;

public class FilterItems {
    //public ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();

    public ArrayList<FoodItem> getFoodFromCalories(ArrayList<FoodItem> menu, double low, double high) {
        ArrayList<FoodItem> menuCalories = new ArrayList<FoodItem>();
        for(int i = 0; i < menu.size(); i++) {
            double c = Double.parseDouble(menu.get(i).getCalories());
            if(c >= low && c <= high) {
                menuCalories.add(menu.get(i));
            }
        }
        return menuCalories;
    }

    public ArrayList<FoodItem> getFoodFromCategory(ArrayList<FoodItem> menu, String category) {
        ArrayList<FoodItem> menuCalories = new ArrayList<FoodItem>();
        for(int i = 0; i < menu.size(); i++) {
            String c = menu.get(i).getCategory();
            if(c.equals(category)) {
                menuCalories.add(menu.get(i));
            }
        }
        return menuCalories;
    }

    public ArrayList<FoodItem> getFoodFromProtein(ArrayList<FoodItem> menu, double low) {
        ArrayList<FoodItem> menuCalories = new ArrayList<FoodItem>();
        for(int i = 0; i < menu.size(); i++) {
            double p = Double.parseDouble(menu.get(i).getProtein());
            if(p >= low) {
                menuCalories.add(menu.get(i));
            }
        }
        return menuCalories;
    }

    public ArrayList<FoodItem> getHealthyFood(ArrayList<FoodItem> menu) {
        ArrayList<FoodItem> menuCalories = new ArrayList<FoodItem>();
        for(int i = 0; i < menu.size(); i++) {
            double p = Double.parseDouble(menu.get(i).getProtein());
            double c = Double.parseDouble(menu.get(i).getCalories());
            if(p >= c) {
                menuCalories.add(menu.get(i));
            }
        }
        return menuCalories;
    }

}
