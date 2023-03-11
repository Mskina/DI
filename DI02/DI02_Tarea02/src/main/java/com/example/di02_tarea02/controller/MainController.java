package com.example.di02_tarea02.controller;

import com.example.di02_tarea02.Alerta;
import com.example.di02_tarea02.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Pantalla de inicio: Debe aparecer una pantalla inicial con el formato que
 * consideres oportuno. El color elegido debe ser distinto si se trata de un
 * supermercado económico o una tienda gourmet. Debes dar una explicación
 * razonada de esa decisión.
 * Debe aparecer la posibilidad de elegir entre iniciar sesión (usuarios
 * registrados), o registrarse.
 */
public class MainController implements Initializable {
    @FXML
    private Label etiquetaSupermercado;
    @FXML
    private Button botonInicioSesion;
    @FXML
    private Button botonRegistro;
    @FXML
    private Button botonSalir;

    @FXML
    protected void onBotonInicioSesionClick() {

        try {
            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("InicioSesion.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Inicio de sesión");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Alerta.lanzarAlerta(Alert.AlertType.ERROR, e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    protected void onBotonRegistroClick() {
        try {
            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Registro.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Registro de usuario");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Alerta.lanzarAlerta(Alert.AlertType.ERROR, e.getMessage());
        }

    }
    @FXML
    protected void onBotonSalirClick() {
        Stage s = (Stage) botonSalir.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        etiquetaSupermercado.getStyleClass().add("etiquetaSupermercado");
    }
}