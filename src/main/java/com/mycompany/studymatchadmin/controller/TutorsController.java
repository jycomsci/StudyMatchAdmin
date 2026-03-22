package com.mycompany.studymatchadmin.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class TutorsController {

    @FXML
    private BarChart<String, Number> earningsChart;

    @FXML
    public void initialize() {

        XYChart.Series<String, Number> earnings = new XYChart.Series<>();
        earnings.setName("Earnings");

        earnings.getData().add(new XYChart.Data<>("Jethro", 18000));
        earnings.getData().add(new XYChart.Data<>("Carlos", 15000));
        earnings.getData().add(new XYChart.Data<>("Rolly", 12000));
        earnings.getData().add(new XYChart.Data<>("Carl", 10000));
        earnings.getData().add(new XYChart.Data<>("Jy", 9000));

        earningsChart.getData().add(earnings);
    }
}