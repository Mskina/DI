package com.example.di02_tarea02;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

public class Alerta {

    public static ButtonType lanzarAlerta(Alert.AlertType tipoAlerta, String mensaje) {
        Alert alerta = new Alert(tipoAlerta);

        DialogPane dialogPane = alerta.getDialogPane();
        dialogPane.getStylesheets().add(MainApplication.class.getResource("css/estilo.css").toExternalForm());

        alerta.setHeaderText(null);
        alerta.setTitle(tipoAlerta.toString());
        alerta.setContentText(mensaje);
        alerta.showAndWait();
        return alerta.getResult();
    }
}
