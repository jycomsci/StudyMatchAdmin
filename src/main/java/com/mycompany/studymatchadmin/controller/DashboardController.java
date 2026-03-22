package com.mycompany.studymatchadmin.controller;

import com.mycompany.studymatchadmin.model.Session;
import com.mycompany.studymatchadmin.service.SessionService;
import com.mycompany.studymatchadmin.database.DatabaseConnection;
import com.mycompany.studymatchadmin.service.AnalyticsService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashboardController {

    private SessionService service = new SessionService();
    private AnalyticsService analyticsService = new AnalyticsService();

    @FXML
    private Label totalRevenueLabel;

    @FXML
    private Label totalCommissionLabel;

    @FXML
    private Label activeSessionsLabel;

    @FXML
    private Label activeTutorsLabel;

    @FXML
    private LineChart<String, Number> revenueChart;

    @FXML
    private TableView<SessionData> sessionsTable;

    @FXML
    private TableColumn<SessionData, String> tutorCol;

    @FXML
    private TableColumn<SessionData, String> studentCol;

    @FXML
    private TableColumn<SessionData, Double> amountCol;

    @FXML
    private TableColumn<SessionData, String> statusCol;

    @FXML
    public void initialize() {

        tutorCol.setCellValueFactory(new PropertyValueFactory<>("tutor"));
        studentCol.setCellValueFactory(new PropertyValueFactory<>("student"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadRevenueChart();
        loadSessionTable();
        loadDashboardStats(); 
    }

    private void loadRevenueChart() {

        XYChart.Series<String, Number> revenue = new XYChart.Series<>();

        revenueChart.getData().add(revenue);
    }

    private void loadSessionTable() {

        List<Session> sessions = service.getRecentSessions();

        ObservableList<SessionData> data = FXCollections.observableArrayList();

        for (Session s : sessions) {
            data.add(new SessionData(
                    s.getTutor(),
                    s.getStudent(),
                    s.getAmount(),
                    s.getStatus()
            ));
        }

        sessionsTable.setItems(data);
    }

private void loadDashboardStats() {

    double revenue = analyticsService.getTotalRevenue();
    double commission = analyticsService.getTotalCommission();
    int sessionsToday = analyticsService.getTodaySessions();

    totalRevenueLabel.setText("₱ " + String.format("%,.0f", revenue));
    totalCommissionLabel.setText("₱ " + String.format("%,.0f", commission));
    activeSessionsLabel.setText(String.valueOf(sessionsToday));
}

    public static class SessionData {

        private String tutor;
        private String student;
        private Double amount;
        private String status;

        public SessionData(String tutor, String student, Double amount, String status) {
            this.tutor = tutor;
            this.student = student;
            this.amount = amount;
            this.status = status;
        }

        public String getTutor() { return tutor; }
        public String getStudent() { return student; }
        public Double getAmount() { return amount; }
        public String getStatus() { return status; }
    }
}