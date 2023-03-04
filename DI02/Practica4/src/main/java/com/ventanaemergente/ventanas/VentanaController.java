package com.ventanaemergente.ventanas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;


import java.io.IOException;

public class VentanaController {
    @FXML
    private Button botonEmergente;


    @FXML
    protected void onbotonEmergenteClick() throws Exception {


        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(VentanaApp.class.getResource("ventanaEmergente.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Error, debe .....!");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            System.out.println(e.getMessage().toString());
            alert.showAndWait();
        }

    }


}