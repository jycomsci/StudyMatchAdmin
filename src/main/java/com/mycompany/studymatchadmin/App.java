package com.mycompany.studymatchadmin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
    launch();
}

    @Override
public void start(Stage stage) throws Exception {

    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/com/mycompany/studymatchadmin/view/login.fxml")
    );

    Scene scene = new Scene(loader.load());

    scene.getStylesheets().add(
        getClass().getResource("/com/mycompany/studymatchadmin/view/style.css").toExternalForm()
    );

    stage.setScene(scene);
    stage.setTitle("StudyMatch Admin");
    stage.show();
}}