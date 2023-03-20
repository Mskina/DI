package com.example.ejercicio2.controller;

import com.example.ejercicio2.Alerta;
import com.example.ejercicio2.MainApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private final ObservableList<String> listaDestinos =
            FXCollections.observableArrayList();
    private final String destino1 = "A Coruña";
    private final String destino2 = "Lugo";
    private final String destino3 = "Ourense";
    private final String destino4 = "Pontevedra";

    @FXML
    private Pane raiz;
    @FXML
    private TextField textoNombre;
    @FXML
    private TextField textoCiudadOrigen;
    @FXML
    private ChoiceBox choiceDestino;
    @FXML
    private TextField textoTarifa;
    @FXML
    private CheckBox checkDesayuno;
    @FXML
    private CheckBox checkComida;
    @FXML
    private CheckBox checkCena;
    @FXML
    private Button botonCalcular;
    @FXML
    private Button botonGuardar;
    @FXML
    private Button botonMostrar;
    @FXML
    private Button botonCancelar;

    /**
     * Botón calcular: asigna el precio a cada casilla de verificación con setUserData() y obtengo
     * dicho importe al seleccionar.
     */
    @FXML
    protected void onBotonCalcularClick() {
        if (!botonCalcular.isDisable()) { // Como este método se reutiliza en calcular, me aseguro de los checks
            checkDesayuno.setUserData(0);
            checkComida.setUserData(0);
            checkCena.setUserData(0);

            int precioExtras = 0;
            int precioDesayuno = 5;
            int precioComida = 12;
            int precioCena = 20;

            if (checkDesayuno.isSelected()) {
                checkDesayuno.setUserData(precioDesayuno);
            }
            if (checkComida.isSelected()) {
                checkComida.setUserData(precioComida);
            }
            if (checkCena.isSelected()) {
                checkCena.setUserData(precioCena);
            }

            try {

                precioExtras = (int) checkDesayuno.getUserData() + (int) checkComida.getUserData() + (int) checkCena.getUserData();

                int precioTotal = calcularTarifa() + precioExtras;
                textoTarifa.setText(String.valueOf(precioTotal));
            } catch (Exception e) {
                Alerta.lanzarAlerta(Alert.AlertType.WARNING, "Debes cubrir los campos necesarios");
            }
        }
    }

    /**
     * Botón guardar: muestra un Alert de información con los datos del usuario.
     */
    @FXML
    protected void onBotonGuardarClick() {
        // Calculo la tarifa por si el usuario todavía no lo ha hecho
        onBotonCalcularClick();

        if (textoNombre.getText().isEmpty() || choiceDestino.getValue().toString().isEmpty()) {
            Alerta.lanzarAlerta(Alert.AlertType.WARNING, "Debes cubrir los campos necesarios");
        } else {
            Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "El usuario " + textoNombre.getText() + " ha comprado un billete de tren con origen " + textoCiudadOrigen.getText() + " y destino " + choiceDestino.getValue() + " y la tarifa es " + textoTarifa.getText());
        }
    }

    @FXML
    protected void onBotonMostrarClick() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Mostrar.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(MainApplication.class.getResource("estilo.css").toExternalForm());


            Stage stage = new Stage();
            stage.setTitle("Destinos");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            Alerta.lanzarAlerta(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    protected void onBotonCancelarClick() {
        for (Node n : raiz.getChildren()) {
            if (n instanceof TextField && !n.isDisable()) {
                ((TextField) n).clear();
            }
        }
    }

    /**
     * Habilito el botón solo cuando hay algún extra marcado
     */
    @FXML
    protected void onCheckClick() {
        botonCalcular.setDisable(!checkDesayuno.isSelected() && !checkComida.isSelected() && !checkCena.isSelected());
    }

    @FXML
    protected int calcularTarifa() {
        int tarifa = 0;
        String destino = (String) choiceDestino.getValue();
        if (destino.equals(destino1)) {
            tarifa = 110;
        } // A Coruña
        if (destino.equals(destino2)) {
            tarifa = 150;
        } // Lugo
        if (destino.equals(destino3)) {
            tarifa = 90;
        } // Ourense
        if (destino.equals(destino4)) {
            tarifa = 30;
        } // Pontevedra

        return tarifa;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaDestinos.add(destino1);
        listaDestinos.add(destino2);
        listaDestinos.add(destino3);
        listaDestinos.add(destino4);
        choiceDestino.setItems(listaDestinos);

        choiceDestino
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
                        textoTarifa.setText(String.valueOf(calcularTarifa()));
                    }
                });
    }
}