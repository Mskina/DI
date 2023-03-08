module com.example.ad02_tarea02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.di02_tarea02 to javafx.fxml;
    exports com.example.di02_tarea02;
    exports com.example.di02_tarea02.controller;
    opens com.example.di02_tarea02.controller to javafx.fxml;
    exports com.example.di02_tarea02.model;
    opens com.example.di02_tarea02.model to javafx.fxml;
}