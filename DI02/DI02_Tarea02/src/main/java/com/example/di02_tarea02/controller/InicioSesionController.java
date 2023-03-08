package com.example.di02_tarea02.controller;

import com.example.di02_tarea02.Alerta;
import com.example.di02_tarea02.MainApplication;
import com.example.di02_tarea02.Storage;
import com.example.di02_tarea02.model.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioSesionController {

    @FXML
    private Button botonAceptar;
    @FXML
    private Button botonCancelar;
    @FXML
    private Label etiquetaUsuario;
    @FXML
    private Label etiquetaContrasena;
    @FXML
    private TextField textoUsuario;
    @FXML
    private PasswordField textoContrasena;

    @FXML
    protected void textosListener() {
        // Deshabilitado el botón Aceptar hasta que haya texto en ambos campos
        if (!textoUsuario.getText().isEmpty() && !textoContrasena.getText().isEmpty()) {
            botonAceptar.setDisable(false);
        } else {
            botonAceptar.setDisable(true);
        }
    }

    @FXML
    protected void onBotonAceptarClick() {
        // Comprobación extra de que hay texto en usuario y contraseña
        if (textoUsuario.getText().isEmpty() || textoContrasena.getText().isEmpty()) {
            Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Comprueba que has introducido correctamente usuario y contraseña.");
            return;
        }

        Cliente cliente = Storage.loginCliente(textoUsuario.getText(), textoContrasena.getText());
        if (cliente == null) {
            Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Comprueba que has introducido correctamente usuario y contraseña.");
            textoContrasena.requestFocus();
            return;
        }

        // Se carga la ventana de ofertas
        try {
            // Cargo la vista de Ofertas
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Ofertas.fxml"));

            // Cargo la ventana de Ofertas
            Parent root = loader.load();

            // Creo el Scene de Ofertas
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setUserData(cliente);
            stage.setTitle("Ofertas");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

            // Cierro la ventana de login
            Stage s = (Stage) botonAceptar.getScene().getWindow();
            s.close();

        } catch (IOException e) {
            Alerta.lanzarAlerta(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    protected void onBotonCancelarClick() {
        Stage stage = (Stage) botonCancelar.getScene().getWindow();
        stage.close();
    }
}
