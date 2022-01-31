package com.example;
import com.google.gson.Gson;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PieChartMenu implements ExampleChart<PieChart> {

    public static void main(String[] args) {
        ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
        String filePath = "/Users/Rbasak101/desktop/McD.json";
        try
        {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            FoodItem[] menu = gson.fromJson(br, FoodItem[].class);
            foodList = new ArrayList<FoodItem>(Arrays.asList(menu));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Analysis analyze = new Analysis();
        HashMap<String, Integer> freqMap = analyze.getCategoryCount(foodList);

        //ExampleChart<PieChart> exampleChart = new PieChartMenu();
        PieChartMenu exampleChart = new PieChartMenu();
        PieChart chart = exampleChart.getChartAuto(freqMap);
        chart.setTitle("McDonald's Menu Composition");
        new SwingWrapper<PieChart>(chart).displayChart();
    }

    @Override
    public PieChart getChart() { // Needs to be implemented
        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

        // Customize Chart
        Color[] sliceColors = new Color[]
                { new Color(224, 68, 14),
                        new Color(30, 144, 255),
                        new Color(236, 143, 110),
                        new Color(50, 205, 50),
                        new Color(128, 0, 0),
                        new Color(238, 130, 238),
                        new Color(255, 255, 102),
                        new Color(105, 105, 105),
                        new Color(222, 184, 135),
                        new Color(128, 128, 0),};
        chart.getStyler().setSeriesColors(sliceColors);

        chart.addSeries("SALAD", 7);
        chart.addSeries("BEVERAGE", 123);
        chart.addSeries("BURGERSANDWICH", 35);
        chart.addSeries("BREAKFAST", 44);
        chart.addSeries("MCCAFE", 146);
        chart.addSeries("SNACKSIDE", 13);
        chart.addSeries("CONDIMENT", 26);
        chart.addSeries("ALLDAYBREAKFAST", 12);
        chart.addSeries("DESSERTSHAKE", 29);
        chart.addSeries("CHICKENFISH", 36);

        return chart;
    }

    public PieChart getChartAuto(HashMap<String, Integer> freqMap) {
        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

        // Customize Chart
        Color[] sliceColors = new Color[]
                { new Color(153, 0, 0),
                        new Color(153, 76, 0),
                        new Color(153, 153, 0),
                        new Color(0, 153, 0),
                        new Color(0, 153, 153),
                        new Color(0, 76, 153),
                        new Color(76, 0, 153),
                        new Color(153, 0, 153),
                        new Color(0, 0, 135),
                        new Color(0, 0, 0),};
        chart.getStyler().setSeriesColors(sliceColors);

        for (HashMap.Entry<String, Integer> set :freqMap.entrySet()) {
            chart.addSeries(set.getKey(), set.getValue().intValue());
        }
        return chart;
    }

    @Override
    public String getExampleChartName() {
        return null;
    }

}
