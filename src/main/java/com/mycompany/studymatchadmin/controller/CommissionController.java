package com.mycompany.studymatchadmin.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class CommissionController {

    @FXML
    private LineChart<String, Number> commissionChart;

    @FXML
    public void initialize() {

        XYChart.Series<String, Number> commission = new XYChart.Series<>();
        commission.setName("Commission");

        commission.getData().add(new XYChart.Data<>("Jan", 4000));
        commission.getData().add(new XYChart.Data<>("Feb", 4800));
        commission.getData().add(new XYChart.Data<>("Mar", 5600));
        commission.getData().add(new XYChart.Data<>("Apr", 6000));
        commission.getData().add(new XYChart.Data<>("May", 5000));
        commission.getData().add(new XYChart.Data<>("Jun", 7000));

        commissionChart.getData().add(commission);
    }
}