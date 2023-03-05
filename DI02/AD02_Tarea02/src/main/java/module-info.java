module com.example.ad02_tarea02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ad02_tarea02 to javafx.fxml;
    exports com.example.ad02_tarea02;
}