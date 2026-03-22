package com.mycompany.studymatchadmin.controller;

import com.mycompany.studymatchadmin.service.SessionService;
import com.mycompany.studymatchadmin.model.Session;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RevenueController {
    
    private SessionService service = new SessionService();

    @FXML
    private LineChart<String, Number> revenueChart;

    @FXML
    public void initialize() {

        XYChart.Series<String, Number> revenue = new XYChart.Series<>();
        revenue.setName("Total Revenue");

        XYChart.Series<String, Number> commission = new XYChart.Series<>();
        commission.setName("Commission");

        revenueChart.getData().addAll(revenue, commission);

        // Load chart data
        loadRevenueChart();
    }

    private void loadRevenueChart() {

        List<Session> sessions = service.getRecentSessions();

        Map<String, Double> revenueByMonth = new HashMap<>();

        for (Session s : sessions) {

            String month = "March"; // replace later with real date parsing

            revenueByMonth.put(
                    month,
                    revenueByMonth.getOrDefault(month, 0.0) + s.getAmount()
            );
        }

        XYChart.Series<String, Number> revenueSeries = new XYChart.Series<>();
        revenueSeries.setName("Revenue");

        for (String month : revenueByMonth.keySet()) {

            revenueSeries.getData().add(
                    new XYChart.Data<>(month, revenueByMonth.get(month))
            );
        }

        revenueChart.getData().add(revenueSeries);
    }
}