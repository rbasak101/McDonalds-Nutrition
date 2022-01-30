package com.example;

import java.util.*;

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
       // System.out.println(total);
        return category;
    }

    public double getAverageCalories(ArrayList<FoodItem> menu) {
        double sum = 0;
        double total = menu.size();
        for(int i = 0; i < menu.size(); i++) {
            String cal = menu.get(i).getCalories();
            double c = Double.parseDouble(cal);
            sum += c;
        }
        double average = sum / total;
        System.out.println(average);
        return average;
    }

    public ArrayList<FoodItem> sortCalories(ArrayList<FoodItem> menu) { // Descending Order
        Collections.sort(menu, Collections.reverseOrder());
        return menu;
    }

    public HashMap<String, List<Integer>> sodiumRangeCategory(ArrayList<FoodItem> menu) {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < menu.size(); i++) {          // Initialize map
            String c = menu.get(i).getCategory();
            if(map.containsKey(c) == false) {
                map.put(c, new ArrayList<Integer>(Arrays.asList(Integer.MAX_VALUE,  Integer.MIN_VALUE)));
            }
        }

        for(int i = 0; i < menu.size(); i++) {  // Find min and max salt range for each category
            String c = menu.get(i).getCategory();
            Integer s = Integer.valueOf(menu.get(i).getSalt());
            List<Integer> saltRange = map.get(c);
            Integer [] range = {saltRange.get(0), saltRange.get(1)};

            if(s <= saltRange.get(0)) {
                range[0] = s;
                //Integer [] a = {s, saltRange.get(1)};
                //map.put(c, new ArrayList<Integer>(Arrays.asList(a[0], a[1])));
            }
            if(s >= saltRange.get(1)) {
                range[1] = s;
               // Integer [] a = {saltRange.get(0), s};
            }
            map.put(c, new ArrayList<Integer>(Arrays.asList(range[0], range[1])));
        }
        return map;
    }



}
