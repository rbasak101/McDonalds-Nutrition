package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Analysis {
    //public ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();

    public HashMap<String, Integer> getCategoryCount(ArrayList<FoodItem> menu) {
        HashMap<String, Integer> category = new HashMap<String, Integer>();
        for(int i = 0; i < menu.size(); i++) {
            String c = menu.get(i).getCategory();
            if(category.containsKey(c)) {
                Integer val = category.get(c);
                category.put(c, val + 1);

            } else {
                category.put(c, 1);
            }
        }
        return category;
    }

    public HashMap<String, Double> getCategoryPercentage(ArrayList<FoodItem> menu) {
        HashMap<String, Double> category = new HashMap<String, Double>();
        double total = 0;
        for(int i = 0; i < menu.size(); i++) {
            String c = menu.get(i).getCategory();
            if(category.containsKey(c)) {
                Double val = category.get(c);
                //double v = val.doubleValue();
                category.put(c, val + 1);

            } else {
                category.put(c, (double)1);
            }
            total++;
        }

        for (Map.Entry<String, Double> entry : category.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            category.put(key, (value / total) * 100);
        }
        System.out.println(total);
        return category;
    }



}
