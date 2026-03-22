package com.mycompany.studymatchadmin.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class AnalyticsController {

    @FXML private StackPane analyticsContent;

    @FXML private Button revenueTab;
    @FXML private Button tutorsTab;
    @FXML private Button studentsTab;
    @FXML private Button sessionsTab;
    @FXML private Button commissionTab;

    @FXML
    public void initialize() {
        setActive(revenueTab);
        loadView("revenue.fxml");
    }

    @FXML
    private void loadRevenue() {
        setActive(revenueTab);
        loadView("revenue.fxml");
    }

    @FXML
    private void loadTutors() {
        setActive(tutorsTab);
        loadView("tutors.fxml");
    }

    @FXML
    private void loadStudents() {
        setActive(studentsTab);
        loadView("students.fxml");
    }

    @FXML
    private void loadSessions() {
        setActive(sessionsTab);
        loadView("sessions.fxml");
    }

    @FXML
    private void loadCommission() {
        setActive(commissionTab);
        loadView("commission.fxml");
    }

    private void loadView(String file) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/mycompany/studymatchadmin/view/" + file)
            );
            analyticsContent.getChildren().clear();
            analyticsContent.getChildren().add(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setActive(Button activeBtn) {
        revenueTab.getStyleClass().remove("tab-active");
        tutorsTab.getStyleClass().remove("tab-active");
        studentsTab.getStyleClass().remove("tab-active");
        sessionsTab.getStyleClass().remove("tab-active");
        commissionTab.getStyleClass().remove("tab-active");

        activeBtn.getStyleClass().add("tab-active");
    }
}