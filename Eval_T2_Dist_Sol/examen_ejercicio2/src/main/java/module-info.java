module com.ventanaemergente.ventanas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.examen.ejercicio2 to javafx.fxml;
    exports com.examen.ejercicio2;
}