package com.example.di02_tarea02;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alerta {

    public static ButtonType lanzarAlerta(Alert.AlertType tipoAlerta, String mensaje) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setHeaderText(null);
        alerta.setTitle(tipoAlerta.toString());
        alerta.setContentText(mensaje);
        alerta.showAndWait();

        return alerta.getResult();
    }
}
