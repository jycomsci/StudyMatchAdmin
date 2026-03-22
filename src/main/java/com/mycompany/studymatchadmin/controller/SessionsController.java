package com.mycompany.studymatchadmin.controller;

import com.mycompany.studymatchadmin.service.SessionService;
import com.mycompany.studymatchadmin.model.Session;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SessionsController {

    @FXML
    private BarChart<String, Number> sessionChart;

    private SessionService service = new SessionService();

    @FXML
    public void initialize() {
        loadSessionChart();
        loadTutorActivity();
    }

    private void loadSessionChart() {

        List<Session> sessions = service.getRecentSessions();

        int completed = 0;
        int cancelled = 0;

        for (Session s : sessions) {

            if ("Completed".equalsIgnoreCase(s.getStatus())) {
                completed++;
            }

            if ("Cancelled".equalsIgnoreCase(s.getStatus())) {
                cancelled++;
            }
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Sessions");

        series.getData().add(new XYChart.Data<>("Completed", completed));
        series.getData().add(new XYChart.Data<>("Cancelled", cancelled));

        sessionChart.getData().add(series);
    }

    private void loadTutorActivity() {

        List<Session> sessions = service.getRecentSessions();

        Map<String, Integer> tutorCount = new HashMap<>();

        for (Session s : sessions) {

            tutorCount.put(
                s.getTutor(),
                tutorCount.getOrDefault(s.getTutor(), 0) + 1
            );
        }

        XYChart.Series<String, Number> tutorSeries = new XYChart.Series<>();
        tutorSeries.setName("Tutor Activity");

        for (String tutor : tutorCount.keySet()) {

            tutorSeries.getData().add(
                new XYChart.Data<>(tutor, tutorCount.get(tutor))
            );
        }

        sessionChart.getData().add(tutorSeries);
    }
}