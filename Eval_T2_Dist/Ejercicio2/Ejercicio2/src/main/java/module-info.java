module com.example.ejercicio2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio2 to javafx.fxml;
    exports com.example.ejercicio2;
    exports com.example.ejercicio2.controller;
    opens com.example.ejercicio2.controller to javafx.fxml;
}