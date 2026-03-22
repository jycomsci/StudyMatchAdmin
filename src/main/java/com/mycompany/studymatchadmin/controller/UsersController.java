package com.mycompany.studymatchadmin.controller;

import com.mycompany.studymatchadmin.database.DatabaseConnection;
import com.mycompany.studymatchadmin.model.User;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.mycompany.studymatchadmin.service.UserService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.scene.layout.HBox;

public class UsersController {

    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, Integer> idColumn;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> roleColumn;
    @FXML
    private TableColumn<User, String> statusColumn;
    
    @FXML
    private ComboBox<String> statusFilter;
    
    @FXML
    private TableColumn<User, Void> actionColumn;
    

    @FXML
    private TextField searchField;
    @FXML
    private ComboBox<String> roleFilter;

    private ObservableList<User> userList;
    private FilteredList<User> filteredData;
    
    private UserService userService = new UserService();

    @FXML
    public void initialize() {
        
        statusFilter.getItems().addAll("All", "Active", "Suspended");
        statusFilter.setValue("All");

        statusFilter.valueProperty().addListener((obs, oldVal, newVal) -> applyFilters());//new feature 03/16/2026

        // Bind columns
        idColumn.setCellValueFactory(data
                -> new SimpleIntegerProperty(data.getValue().getId()).asObject());

        nameColumn.setCellValueFactory(data
                -> new SimpleStringProperty(data.getValue().getName()));

        emailColumn.setCellValueFactory(data
                -> new SimpleStringProperty(data.getValue().getEmail()));

        roleColumn.setCellValueFactory(data
                -> new SimpleStringProperty(data.getValue().getRole()));

        statusColumn.setCellValueFactory(data
                -> new SimpleStringProperty(data.getValue().getStatus()));

        loadUsersFromDatabase() ;

        statusColumn.setCellFactory(column -> new TableCell<User, String>() {
            @Override
            protected void updateItem(String status, boolean empty) {
                super.updateItem(status, empty);

                if (empty || status == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(status);

                    if (status.equalsIgnoreCase("Active")) {
                        setStyle("-fx-text-fill: #16a34a; -fx-font-weight: bold;");
                    } else {
                        setStyle("-fx-text-fill: #dc2626; -fx-font-weight: bold;");
                    }
                }
            }
        });
        
        
        actionColumn.setCellFactory(param -> new TableCell<>() {

    private final Button suspendBtn = new Button("Suspend");
    private final Button deleteBtn = new Button("Delete");

    {
        suspendBtn.setOnAction(event -> {

            User user = getTableView().getItems().get(getIndex());

            userService.suspendUser(user.getId());

            loadUsersFromDatabase();
        });

        deleteBtn.setOnAction(event -> {

            User user = getTableView().getItems().get(getIndex());

            userService.deleteUser(user.getId());

            loadUsersFromDatabase();
        });
    }

    private final HBox pane = new HBox(10, suspendBtn, deleteBtn);

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(empty ? null : pane);
    }
});
        

        roleFilter.getItems().addAll("All", "Student", "Tutor", "Admin");
        roleFilter.setValue("All");

        // Search Listener
        searchField.textProperty().addListener((obs, oldVal, newVal) -> applyFilters());

        // Role Listener
        roleFilter.valueProperty().addListener((obs, oldVal, newVal) -> applyFilters());
    }

private void loadUsersFromDatabase(){

    userList = FXCollections.observableArrayList(
            userService.getUsers()
    );

    filteredData = new FilteredList<>(userList, p -> true);

    userTable.setItems(filteredData);
}

public void suspendUser(int id){

    try{
        
        Connection conn = DatabaseConnection.connect();

        String sql = "UPDATE users SET status='Suspended' WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

    }catch(Exception e){
        e.printStackTrace();
    }

}


public void deleteUser(int id){

    try{

        Connection conn = DatabaseConnection.connect();

        String sql = "DELETE FROM users WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

    }catch(Exception e){
        e.printStackTrace();
    }

}


private void applyFilters() {

    String searchText = searchField.getText().toLowerCase();
    String selectedRole = roleFilter.getValue();
    String selectedStatus = statusFilter.getValue();

    filteredData.setPredicate(user -> {

        boolean matchesSearch =
                user.getName().toLowerCase().contains(searchText) ||
                user.getEmail().toLowerCase().contains(searchText);

        boolean matchesRole =
                selectedRole.equals("All") ||
                user.getRole().equalsIgnoreCase(selectedRole);

        boolean matchesStatus =
                selectedStatus.equals("All") ||
                user.getStatus().equalsIgnoreCase(selectedStatus);

        return matchesSearch && matchesRole && matchesStatus;
    });
}

@FXML
private void handleRefresh() {

    loadUsersFromDatabase();
    filteredData = new FilteredList<>(userList, p -> true);
    userTable.setItems(filteredData);

}}