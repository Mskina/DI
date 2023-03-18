module com.example.repaso01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.repaso01 to javafx.fxml;
    exports com.example.repaso01;
}