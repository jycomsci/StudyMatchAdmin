package com.mycompany.studymatchadmin.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import com.mycompany.studymatchadmin.service.AuthService;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    AuthService authService = new AuthService();

    @FXML
    private void handleLogin() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (authService.login(username, password)) {

            System.out.println("Login Success");

            try {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/com/mycompany/studymatchadmin/view/MainLayout.fxml")
                );

                Parent root = loader.load();

                Stage stage = (Stage) usernameField.getScene().getWindow();

                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            messageLabel.setText("Invalid username or password");

        }
    }
}