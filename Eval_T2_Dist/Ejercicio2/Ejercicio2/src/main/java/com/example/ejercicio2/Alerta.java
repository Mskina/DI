package com.example.ejercicio2;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

public class Alerta {

    public static void lanzarAlerta(Alert.AlertType tipoAlerta, String mensaje) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setHeaderText(null);
        alerta.setTitle(tipoAlerta.toString());
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

