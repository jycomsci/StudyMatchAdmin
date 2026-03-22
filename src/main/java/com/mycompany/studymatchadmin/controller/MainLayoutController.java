package com.mycompany.studymatchadmin.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainLayoutController {

    @FXML private StackPane contentArea;
    @FXML private VBox sidebar;
    @FXML private BorderPane rootPane;
    
    @FXML private ImageView logoImage;

    @FXML private Button dashboardBtn;
    @FXML private Button analyticsBtn;
    @FXML private Button reportsBtn;
    @FXML private Button settingsBtn;
    @FXML
    private Button usersBtn;


    private boolean collapsed = false;

    @FXML
    public void initialize() {
        rootPane.getStyleClass().add("accent-purple");
        loadDashboard();
    }
    


    private void loadView(String file) {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/mycompany/studymatchadmin/view/" + file)
            );
            Parent view = loader.load();
            contentArea.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

private void setActive(Button btn) {

    dashboardBtn.getStyleClass().remove("active");
    usersBtn.getStyleClass().remove("active");
    analyticsBtn.getStyleClass().remove("active");
    reportsBtn.getStyleClass().remove("active");
    settingsBtn.getStyleClass().remove("active");

    btn.getStyleClass().add("active");
}

    @FXML
    private void loadDashboard() {
        setActive(dashboardBtn);
        loadView("dashboard.fxml");
    }

    @FXML
    private void loadAnalytics() {
        setActive(analyticsBtn);
        loadView("analytics.fxml");
    }

    @FXML
    private void loadReports() {
        setActive(reportsBtn);
        loadView("reports.fxml");
    }

    @FXML
    private void loadSettings() {
        setActive(settingsBtn);
        loadView("settings.fxml");
    }

    
    @FXML
private void loadUsers() {
    setActive(usersBtn);
    loadView("users.fxml");
}


    @FXML

    private void toggleSidebar() {

        if (collapsed) {
            sidebar.setPrefWidth(240);
            logoImage.setFitWidth(150);
        } else {
            sidebar.setPrefWidth(80);
            logoImage.setFitWidth(50);
        }

        collapsed = !collapsed;
    }

    @FXML
    private void logout() throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/mycompany/studymatchadmin/view/login.fxml")
        );
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(
                getClass().getResource("/com/mycompany/studymatchadmin/view/style.css")
                        .toExternalForm()
        );

        Stage stage = (Stage) contentArea.getScene().getWindow();
        stage.setScene(scene);
    }
}