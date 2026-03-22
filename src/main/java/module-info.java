module com.mycompany.studymatchadmin {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    exports com.mycompany.studymatchadmin;
    exports com.mycompany.studymatchadmin.controller;

    opens com.mycompany.studymatchadmin.controller to javafx.fxml;
}