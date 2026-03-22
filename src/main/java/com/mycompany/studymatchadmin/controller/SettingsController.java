package com.mycompany.studymatchadmin.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class SettingsController implements Initializable {

    private Scene getScene(ActionEvent event) {
        Node source = (Node) event.getSource();
        return source.getScene();
    }

    // =============================
    // THEME MODE
    // =============================

    @FXML
    private void setLight(ActionEvent event) {
        Scene scene = getScene(event);
        scene.getRoot().getStyleClass().remove("dark-mode");
    }

    @FXML
    private void setDark(ActionEvent event) {
        Scene scene = getScene(event);
        if (!scene.getRoot().getStyleClass().contains("dark-mode")) {
            scene.getRoot().getStyleClass().add("dark-mode");
        }
    }

    // =============================
    // ACCENT COLORS
    // =============================

    @FXML
    private void setPurple(ActionEvent event) {
        applyAccent(event, "accent-purple");
    }

    @FXML
    private void setBlue(ActionEvent event) {
        applyAccent(event, "accent-blue");
    }

    @FXML
    private void setGreen(ActionEvent event) {
        applyAccent(event, "accent-green");
    }

    private void applyAccent(ActionEvent event, String accentClass) {
        Scene scene = getScene(event);

        scene.getRoot().getStyleClass().removeAll(
                "accent-purple",
                "accent-blue",
                "accent-green"
        );

        if (!scene.getRoot().getStyleClass().contains(accentClass)) {
            scene.getRoot().getStyleClass().add(accentClass);
            
            System.out.println(scene.getRoot().getStyleClass());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // nothing needed here
    }
}