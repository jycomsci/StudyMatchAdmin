package com.mycompany.studymatchadmin.controller;

import com.mycompany.studymatchadmin.model.ReportData;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReportsController {

    @FXML private TableView<ReportData> reportTable;
    @FXML private TableColumn<ReportData, String> monthColumn;
    @FXML private TableColumn<ReportData, Integer> sessionsColumn;
    @FXML private TableColumn<ReportData, Integer> usersColumn;
    @FXML private TableColumn<ReportData, Double> accuracyColumn;

    @FXML
    public void initialize() {

        monthColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getMonth()));

        sessionsColumn.setCellValueFactory(data ->
                new SimpleIntegerProperty(data.getValue().getSessions()).asObject());

        usersColumn.setCellValueFactory(data ->
                new SimpleIntegerProperty(data.getValue().getNewUsers()).asObject());

        accuracyColumn.setCellValueFactory(data ->
                new SimpleDoubleProperty(data.getValue().getAccuracy()).asObject());

        reportTable.setItems(FXCollections.observableArrayList(
                new ReportData("January", 120, 45, 75.0),
                new ReportData("February", 180, 60, 78.0),
                new ReportData("March", 240, 80, 82.0),
                new ReportData("April", 310, 95, 85.0),
                new ReportData("May", 400, 110, 88.0),
                new ReportData("June", 520, 140, 91.0)
        ));
    }

    @FXML
    private void handleExport() {
        System.out.println("Exporting report...");
    }
}