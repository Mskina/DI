module com.mat.ciclos.matricularciclos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.mat.ciclos.matricularciclos to javafx.fxml;
    exports com.mat.ciclos.matricularciclos;
}