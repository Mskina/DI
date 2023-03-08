package com.mat.ciclos.matricularciclos;

import javafx.scene.control.Alert;

import static javafx.scene.control.Alert.AlertType.WARNING;

public class Alerta extends Alert {
    private static final AlertType Error =WARNING ;

    public Alerta(AlertType alertType) {
        super(Error);
    }
}
