package com.mycompany.studymatchadmin.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class StudentsController {

    @FXML
    private LineChart<String, Number> growthChart;

    @FXML
    public void initialize() {

        XYChart.Series<String, Number> growth = new XYChart.Series<>();
        growth.setName("Students");

        growth.getData().add(new XYChart.Data<>("Jan", 1800));
        growth.getData().add(new XYChart.Data<>("Feb", 2200));
        growth.getData().add(new XYChart.Data<>("Mar", 3000));
        growth.getData().add(new XYChart.Data<>("Apr", 4500));
        growth.getData().add(new XYChart.Data<>("May", 6000));
        growth.getData().add(new XYChart.Data<>("Jun", 7500));

        growthChart.getData().add(growth);
    }
}